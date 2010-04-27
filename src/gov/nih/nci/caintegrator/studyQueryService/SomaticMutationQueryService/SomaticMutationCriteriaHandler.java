package gov.nih.nci.caintegrator.studyQueryService.SomaticMutationQueryService;

import gov.nih.nci.caintegrator.domain.common.bean.NumericMeasurement;
import gov.nih.nci.caintegrator.studyQueryService.dto.annotation.AnnotationCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.somaticMutation.SomaticMutationAnnotationCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.somaticMutation.SomaticMutationFindingCriteria;
import gov.nih.nci.caintegrator.util.HQLHelper;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;


public class SomaticMutationCriteriaHandler {


    public  List<String> handle(SomaticMutationFindingCriteria smCrit, Session session) {
        if (smCrit == null) return null; // indicating that this crit can be ignored in the calling method
        HashMap params = new HashMap();  // to hold HQL Parameters

        StringBuffer spHQL = new StringBuffer(" SELECT sm.id FROM SomaticMutation sm  " +
                                            " {0} {1} WHERE ");

        /* 1. Handle the StudyParticipant Attributes Criteria itself */
        boolean hqlAppended = handleSomaticMutationAttrCriteria(smCrit, spHQL, params);

        /* 2.  Handle AnnotationCriteria if specified */
        StringBuffer annotJoin = new StringBuffer("");
        AnnotationCriteria annotCrit = smCrit.getGeneAnnotationCriteria() ;
        if (annotCrit != null) 
        {
        	annotJoin = handleAnnotationCriteria(annotCrit , spHQL, params);
        }

        /* 2.  Handle SomaticMutationAnnotationCriteria if specified */
        StringBuffer somAnnotJoin = new StringBuffer("");
        SomaticMutationAnnotationCriteria somAnnotCrit = smCrit.getSomaticMutAnnotCriteria() ;
        if (somAnnotJoin != null) 
        {
        	somAnnotJoin = handleSomaticMutationAnnotationCriteria(somAnnotCrit , spHQL, params);
        }
       
        /* 5. now substitute the {0} & {1} parameter studyJoin & populationJoin */
        String tmp = spHQL.toString();
        spHQL = new StringBuffer(MessageFormat.format(tmp, new Object[] {
        		annotJoin, somAnnotJoin}));

        /* 6. Do some HouseKeeping tasks */
        String tmpHSQL = HQLHelper.removeTrailingToken(spHQL, "AND");
        String finalHSQL = HQLHelper.removeTrailingToken(new StringBuffer(tmpHSQL), "OR");

        /* 7.  Execute total HQL to retrive Specimens */
        // first check if every condition is empty,  If it is return no specimenIDs
        if (annotJoin.length() < 1 && somAnnotJoin.length() < 1)
            return new ArrayList<String>();

        Query q = session.createQuery(finalHSQL);
        HQLHelper.setParamsOnQuery(params, q);
        List<String>  somMutIDs = q.list();

        System.out.println("specimenIDs "+ somMutIDs.size()  +" retrieved from StudyParticipantCriteria: " +smCrit.toString());
        return somMutIDs;
    }


    public static boolean handleSomaticMutationAttrCriteria(SomaticMutationFindingCriteria crit, StringBuffer spHQL, HashMap params) {   

        Integer baseNumber = crit.getBaseNumber();
        Integer chromosome = crit.getChromosome();
        Integer locationByCodon = crit.getLocationByCodon();
        Integer locationByExon = crit.getLocationByExon();
        Integer locationByIntron = crit.getLocationByIntron();
        String functionalChange = crit.getFunctionalChange();
        String mutantAminoAcid = crit.getMutantAminoAcid();
        String mutantCodon = crit.getMutantCodon();
        String mutationStatus = crit.getMutationStatus();
        String mutationType = crit.getMutationType();
        Integer ncbiBuild = crit.getNCBI_build();
        Long numberOfCodonsAffected = crit.getNumberOfCodonsAffected();
        String sizeOfMutation = crit.getSizeOfMutation();
        String wildtypeAminoAcid = crit.getWildtypeAminoAcid();
        String wildtypeCodon = crit.getWildtypeCodon();
        
        boolean hqlAppended = false;

        /* add StudyPartcipant attributes crit itself */
        if (baseNumber != null) {
            spHQL.append(" sm.baseNumber = :baseNumber AND ");
            params.put("baseNumber", baseNumber);
            hqlAppended = true;
        }

        NumericMeasurement ageAtEnroll = new NumericMeasurement();

        if (chromosome != null) {
        	 spHQL.append(" sm.chromosome = :chromosome AND ");
             params.put("chromosome", chromosome);
             hqlAppended = true;
        }


        if (locationByCodon != null) {
            spHQL.append(" sm.locationByCodon = :locationByCodon AND ");
            params.put("locationByCodon", locationByCodon );
            hqlAppended = true;
        }

        if (locationByExon != null) {
            spHQL.append(" sm.locationByExon = :locationByExon AND ");
            params.put("locationByExon", locationByExon );
            hqlAppended = true;
        }

       
        if (locationByIntron != null) {
            spHQL.append(" sm.locationByIntron = :locationByIntron AND ");
            params.put("locationByIntron", locationByIntron );
            hqlAppended = true;
        }
       

        if (functionalChange != null) {
            spHQL.append(" sp.functionalChange = :functionalChange AND ");
            params.put("functionalChange", functionalChange );
            hqlAppended = true;
        }

        if(mutantAminoAcid != null) {
            spHQL.append(" sp.mutantAminoAcid  = :mutantAminoAcid AND ");
            params.put("mutantAminoAcid", mutantAminoAcid );
            hqlAppended = true;
        }
        
        if(mutantCodon != null) {
            spHQL.append(" sp.mutantCodon  = :mutantCodon AND ");
            params.put("mutantCodon", mutantCodon );
            hqlAppended = true;
        }
        if(mutationStatus != null) {
            spHQL.append(" sp.mutationStatus  = :mutationStatus AND ");
            params.put("mutationStatus", mutationStatus );
            hqlAppended = true;
        }
        if(mutationType != null) {
            spHQL.append(" sp.mutationType  = :mutationType AND ");
            params.put("mutationType", mutationType );
            hqlAppended = true;
        }
        if(ncbiBuild != null) {
            spHQL.append(" sp.ncbiBuild  = :ncbiBuild AND ");
            params.put("ncbiBuild", ncbiBuild );
            hqlAppended = true;
        }
        if(numberOfCodonsAffected != null) {
            spHQL.append(" sp.numberOfCodonsAffected  = :numberOfCodonsAffected AND ");
            params.put("numberOfCodonsAffected", numberOfCodonsAffected );
            hqlAppended = true;
        }
        if(sizeOfMutation != null) {
            spHQL.append(" sp.sizeOfMutation  = :sizeOfMutation AND ");
            params.put("sizeOfMutation", sizeOfMutation );
            hqlAppended = true;
        }
        if(wildtypeAminoAcid != null) {
            spHQL.append(" sp.wildtypeAminoAcid  = :wildtypeAminoAcid AND ");
            params.put("wildtypeAminoAcid", wildtypeAminoAcid );
            hqlAppended = true;
        }
        if(wildtypeCodon != null) {
            spHQL.append(" sp.wildtypeCodon  = :wildtypeCodon AND ");
            params.put("wildtypeCodon", wildtypeCodon );
            hqlAppended = true;
        }

        return hqlAppended;
    }


    public static StringBuffer handleSomaticMutationAnnotationCriteria(SomaticMutationAnnotationCriteria somCrit, StringBuffer smHQL, HashMap params) {

        StringBuffer somaticMutationJoin = new StringBuffer("");       
        String aminoAcid = somCrit.getAminoacid() ;
        String codonSeq =  somCrit.getCodonsequence() ;
        String endPosition = somCrit.getEndposition() ;
        String ensemblID = somCrit.getEnsemblID() ;
        String entrezGeneID = somCrit.getEntrezGeneID() ;
        String gSCConservationscore = somCrit.getGSCConservationscore() ;
        String hUGOsymbol = somCrit.getHUGOsymbol() ;
        String interproannotation = somCrit.getInterproannotation() ;
        String nCBIbuild = somCrit.getNCBIbuild() ;
        String pfamannotation = somCrit.getPfamannotation() ;
        String refseqAllele = somCrit.getRefseqAllele() ;       
        String sIFTprediction = somCrit.getSIFTprediction() ;
        String startposition = somCrit.getStartposition() ;
        String Strand = somCrit.getStrand() ;
        String transcriptid = somCrit.getTranscriptid() ;
        String transcriptPosition = somCrit.getTranscriptposition() ;
        String transcriptRegion = somCrit.getTranscriptregion() ;
        String uCSCConservationscore = somCrit.getUCSCConservationscore();
        String variantAllele = somCrit.getVariantAllele() ;
        String variantClassification = somCrit.getVariantclassification() ;
        String variantSize = somCrit.getVariantsize() ;
        String variantType = somCrit.getVarianttype() ;
        
        if (aminoAcid != null) {
        	somaticMutationJoin.append(" JOIN sm.somaticMutationAnnotation ");
        	smHQL.append(" sm.somaticMutationAnnotation.aminoAcid = :aminoAcid AND ");
            params.put("aminoAcid", aminoAcid);
        }
        
        if(codonSeq != null) {
            if (somaticMutationJoin.length() < 1)
            	somaticMutationJoin.append(" JOIN sm.somaticMutationAnnotation ");
            smHQL.append(" sp.codonSeq  = :codonSeq AND ");
            params.put("codonSeq", codonSeq );
        }
        if(ensemblID != null) {
            if (somaticMutationJoin.length() < 1)
            	somaticMutationJoin.append(" JOIN sm.somaticMutationAnnotation ");
            smHQL.append(" sp.ensemblID  = :ensemblID AND ");
            params.put("ensemblID", ensemblID );
        }
        if(entrezGeneID != null) {
            if (somaticMutationJoin.length() < 1)
            	somaticMutationJoin.append(" JOIN sm.somaticMutationAnnotation ");
            smHQL.append(" sp.entrezGeneID  = :entrezGeneID AND ");
            params.put("entrezGeneID", entrezGeneID );
        }
        if(hUGOsymbol != null) {
            if (somaticMutationJoin.length() < 1)
            	somaticMutationJoin.append(" JOIN sm.somaticMutationAnnotation ");
            smHQL.append(" sp.hUGOsymbol  = :hUGOsymbol AND ");
            params.put("hUGOsymbol", hUGOsymbol );
        }
        if(Strand != null) {
            if (somaticMutationJoin.length() < 1)
            	somaticMutationJoin.append(" JOIN sm.somaticMutationAnnotation ");
            smHQL.append(" sp.Strand  = :Strand AND ");
            params.put("Strand", Strand );
        }
        if(transcriptid != null) {
            if (somaticMutationJoin.length() < 1)
            	somaticMutationJoin.append(" JOIN sm.somaticMutationAnnotation ");
            smHQL.append(" sp.transcriptid  = :transcriptid AND ");
            params.put("transcriptid", transcriptid );
        }
        if(transcriptPosition != null) {
            if (somaticMutationJoin.length() < 1)
            	somaticMutationJoin.append(" JOIN sm.somaticMutationAnnotation ");
            smHQL.append(" sp.transcriptPosition  = :transcriptPosition AND ");
            params.put("transcriptPosition", transcriptPosition );
        }
        if(transcriptRegion != null) {
            if (somaticMutationJoin.length() < 1)
            	somaticMutationJoin.append(" JOIN sm.somaticMutationAnnotation ");
            smHQL.append(" sp.transcriptRegion  = :transcriptRegion AND ");
            params.put("transcriptRegion", transcriptRegion );
        }
        if(uCSCConservationscore != null) {
            if (somaticMutationJoin.length() < 1)
            	somaticMutationJoin.append(" JOIN sm.somaticMutationAnnotation ");
            smHQL.append(" sp.uCSCConservationscore  = :uCSCConservationscore AND ");
            params.put("uCSCConservationscore", uCSCConservationscore );
        }
        if(variantAllele != null) {
            if (somaticMutationJoin.length() < 1)
            	somaticMutationJoin.append(" JOIN sm.somaticMutationAnnotation ");
            smHQL.append(" sp.variantAllele  = :variantAllele AND ");
            params.put("variantAllele", variantAllele );
        }
        
        if(variantClassification != null) {
            if (somaticMutationJoin.length() < 1)
            	somaticMutationJoin.append(" JOIN sm.somaticMutationAnnotation ");
            smHQL.append(" sp.variantClassification  = :variantClassification AND ");
            params.put("variantClassification", variantClassification );
        }
        
        if(variantSize != null) {
            if (somaticMutationJoin.length() < 1)
            	somaticMutationJoin.append(" JOIN sm.somaticMutationAnnotation ");
            smHQL.append(" sp.variantSize  = :variantSize AND ");
            params.put("variantSize", variantSize );
        }
        
        if(variantType != null) {
            if (somaticMutationJoin.length() < 1)
            	somaticMutationJoin.append(" JOIN sm.somaticMutationAnnotation ");
            smHQL.append(" sp.variantType  = :variantType AND ");
            params.put("variantType", variantType );
        }
        
        
        return somaticMutationJoin;
    }


    public static StringBuffer handleAnnotationCriteria(AnnotationCriteria annotCrit, StringBuffer studyHql, HashMap params)
    {

        StringBuffer annotJoin = new StringBuffer("");
        if (annotCrit != null)  {
            String cytoStart = annotCrit.getCytobandCriteria().getStart();
            if (cytoStart != null) {
            	annotJoin.append(" JOIN sm.somaticmutGene ");
                studyHql.append(" sm.somaticmutGene.cytoband = :cytoStart AND ");
                params.put("cytoStart", cytoStart);
            }
            
        }
        return annotJoin;
    }
}