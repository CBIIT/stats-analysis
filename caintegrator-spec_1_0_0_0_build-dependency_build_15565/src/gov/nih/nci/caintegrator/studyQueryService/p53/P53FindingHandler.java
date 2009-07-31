package gov.nih.nci.caintegrator.studyQueryService.p53;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import gov.nih.nci.caintegrator.domain.finding.mutation.p53.bean.P53MutationFinding;
import gov.nih.nci.caintegrator.studyQueryService.dto.finding.SpecimenBasedMolecularFindingCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.p53.P53FindingCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.study.SpecimenCriteria;
import gov.nih.nci.caintegrator.studyQueryService.finding.SpecimenBasedMolecularFindingHandler;
import gov.nih.nci.caintegrator.studyQueryService.study.SpecimenHandler;
import gov.nih.nci.caintegrator.util.HQLHelper;

public class P53FindingHandler extends SpecimenBasedMolecularFindingHandler {
	
	 private static Logger logger = Logger.getLogger(P53FindingHandler.class);
	 
	 protected SessionFactory sessionFactory;
	
		

	@Override
	protected Class getFindingType() {
		return P53MutationFinding.class;
	}

	@Override
	protected StringBuilder handleCriteria(
			SpecimenBasedMolecularFindingCriteria inCriteria,
			HashMap<String, Object> inParams, Session inSession) {
		
		
		    logger.debug("Entering handler for  P53FindingHandler");
		    
		    P53FindingCriteria theCriteria = (P53FindingCriteria) inCriteria;
		    
		    StringBuilder theHQL = new StringBuilder();
		    
		    // Start of the where clause
	    	 
	     	 theHQL.append(" select p53Mutation.specimen.patientDID from P53MutationFinding as p53Mutation LEFT JOIN p53Mutation.specimen ");  
	    	 
	                         
	         String theANDString = " WHERE ";        
	       
	         
	         /////////////////////////////////////////////////////
	         // Handle mutation status collection
	         /////////////////////////////////////////////////////
	         if (theCriteria.getMutationStatusCollection() != null && theCriteria.getMutationStatusCollection().size() > 0)
	         {
	             theHQL.append(theANDString + " p53Mutation.mutationStatus IN (:p53Mutation_mutationStatus) ");
	             inParams.put("p53Mutation_mutationStatus", theCriteria.getMutationStatusCollection());
	             theANDString = " AND ";
	         }        theANDString = " AND ";
	         
	         
	         /////////////////////////////////////////////////////
	         // Handle mutation type collection
	         /////////////////////////////////////////////////////
	         if (theCriteria.getMutationTypeCollection() != null && theCriteria.getMutationTypeCollection().size() > 0)
	         {
	             theHQL.append(theANDString + " p53Mutation.mutationType IN (:p53Mutation_mutationType) ");
	             inParams.put("p53Mutation_mutationType", theCriteria.getMutationTypeCollection());
	             theANDString = " AND ";
	         }        
	         
	         logger.info("HQL: " + theHQL.toString());
	         logger.debug("Exiting handleCriteria");

	         return theHQL;   
	}

	
	  public Collection<P53MutationFinding> getP53Findings(P53FindingCriteria inCriteria)
	     {
		     logger.debug("Entering getFindings");
	         Session theSession = sessionFactory.getCurrentSession();
	         Set<P53MutationFinding> theResults = new HashSet<P53MutationFinding>();
	         
	         try
	         {
	             
	             HashMap<String, Object> theParams = new HashMap<String, Object>();

	             StringBuilder theHQL = handleCriteria(inCriteria, theParams,null);	             
	        
	        	 SpecimenCriteria theSpecimenCriteria = inCriteria.getSpecimenCriteria();
	        	  
	        	 if (theSpecimenCriteria != null)
	             {
	                 if(theHQL.toString().contains("WHERE")){
	                     theHQL.append(" AND p53Mutation.specimen IN (");
	                 }
	                 else{
	                     theHQL.append(" WHERE p53Mutation.specimen IN (");
	                 }

	                 SpecimenHandler theSpecimenHandler = theSpecimenCriteria.getHandler();
	                 StringBuilder theSpecimenHQL = theSpecimenHandler.handleCriteria(theSpecimenCriteria, theParams);
	                 theHQL.append(theSpecimenHQL + ")");
	                 
	             }
	        	 
	        	 logger.info("HQL7777777777: " + theHQL.toString());
	             Query q = theSession.createQuery(theHQL.toString());             
	             HQLHelper.setParamsOnQuery(theParams, q);
	             List<String> theObjects = q.list();
	             
	             if(theObjects.size()>1000){
	                 List<List<String>> segmentedObjects = new ArrayList<List<String>>();
	                 List<String> myObjects = new ArrayList<String>();
	                 
	                 for(int i=0;i<theObjects.size();i++){
	                     if(i!=0 && i%1000==0){
	                         List<String> tempObjects = new ArrayList<String>(myObjects);
	                         segmentedObjects.add(tempObjects);
	                         myObjects.clear();
	                     }
	                     else{
	                         myObjects.add(theObjects.get(i));
	                     }
	                 }
	                 if(!myObjects.isEmpty()){
	                     segmentedObjects.add(myObjects);
	                 }
	                 
	                 /* now I should have segemented groups of 1000 (or less) to iterate over
	                  and populate into my "in" clause for each group. When the queries complete,
	                  I add the results into my results object. */
	                 
	                 for(List list: segmentedObjects){
	                     String theFinalHQL = "select p53Mutation from P53MutationFinding as p53Mutation LEFT JOIN FETCH p53Mutation.specimen " +
	                     " WHERE p53Mutation.specimen.patientDID IN (:p53Mutation_objects)";
	                     System.out.println(theFinalHQL);
	                     Query theFinalQuery = null;
	                     theFinalQuery = theSession.createQuery(theFinalHQL);
	                     theFinalQuery.setParameterList("p53Mutation_objects",list);
	                     Collection<P53MutationFinding> objs = theFinalQuery.list();
	                     theResults.addAll(objs);
	                 }
	            }
	             
	             //if the objects do not exceed 1000, procedd with a regular in clause
	           else{
	                 String theFinalHQL = "select p53Mutation from P53MutationFinding as p53Mutation LEFT JOIN FETCH p53Mutation.specimen " +
	                 " WHERE p53Mutation.specimen.patientDID IN (:p53Mutation_objects)";
	                 System.out.println(theFinalHQL);
	                 Query theFinalQuery = null;
	                 theFinalQuery = theSession.createQuery(theFinalHQL);
	                 theFinalQuery.setParameterList("p53Mutation_objects",theObjects);
	                 Collection<P53MutationFinding> objs = theFinalQuery.list();
	                 theResults.addAll(objs);
	             }
	         }     
	             catch (Exception e)
	             {
	                 e.printStackTrace();
	                 logger.error("Error getting findings: ", e);
	             }
	             
	             logger.debug("Exiting getFindings");

	             return theResults;
	     }
	  
	  /**
	     * @return Returns the sessionFactory.
	     */
	    public SessionFactory getSessionFactory() {
	        return sessionFactory;
	    }


	    /**
	     * @param sessionFactory The sessionFactory to set.
	     */
	    public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }
}
