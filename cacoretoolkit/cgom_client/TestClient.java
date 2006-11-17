import gov.nih.nci.caintegrator.domain.analysis.snp.SNPAnalysisGroup;
import gov.nih.nci.caintegrator.domain.analysis.snp.SNPAssociationAnalysis;
import gov.nih.nci.caintegrator.domain.analysis.snp.SNPAssociationFinding;
import gov.nih.nci.caintegrator.domain.annotation.gene.GeneBiomarker;
import gov.nih.nci.caintegrator.domain.annotation.snp.SNPAnnotation;
import gov.nih.nci.caintegrator.domain.annotation.snp.SNPAssay;
import gov.nih.nci.caintegrator.domain.annotation.snp.SNPPanel;
import gov.nih.nci.caintegrator.domain.finding.variation.snpFrequency.SNPFrequencyFinding;
import gov.nih.nci.caintegrator.domain.study.Population;
import gov.nih.nci.caintegrator.domain.study.Specimen;
import gov.nih.nci.caintegrator.domain.study.Study;
import gov.nih.nci.system.applicationservice.ApplicationService;
import gov.nih.nci.system.applicationservice.ApplicationServiceProvider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

/**
* caIntegrator License
* 
* Copyright 2001-2005 Science Applications International Corporation ("SAIC"). 
* The software subject to this notice and license includes both human readable source code form and machine readable, 
* binary, object code form ("the caIntegrator Software"). The caIntegrator Software was developed in conjunction with 
* the National Cancer Institute ("NCI") by NCI employees and employees of SAIC. 
* To the extent government employees are authors, any rights in such works shall be subject to Title 17 of the United States
* Code, section 105. 
* This caIntegrator Software License (the "License") is between NCI and You. "You (or "Your") shall mean a person or an 
* entity, and all other entities that control, are controlled by, or are under common control with the entity. "Control" 
* for purposes of this definition means (i) the direct or indirect power to cause the direction or management of such entity,
*  whether by contract or otherwise, or (ii) ownership of fifty percent (50%) or more of the outstanding shares, or (iii) 
* beneficial ownership of such entity. 
* This License is granted provided that You agree to the conditions described below. NCI grants You a non-exclusive, 
* worldwide, perpetual, fully-paid-up, no-charge, irrevocable, transferable and royalty-free right and license in its rights 
* in the caIntegrator Software to (i) use, install, access, operate, execute, copy, modify, translate, market, publicly 
* display, publicly perform, and prepare derivative works of the caIntegrator Software; (ii) distribute and have distributed 
* to and by third parties the caIntegrator Software and any modifications and derivative works thereof; 
* and (iii) sublicense the foregoing rights set out in (i) and (ii) to third parties, including the right to license such 
* rights to further third parties. For sake of clarity, and not by way of limitation, NCI shall have no right of accounting
* or right of payment from You or Your sublicensees for the rights granted under this License. This License is granted at no
* charge to You. 
* 1. Your redistributions of the source code for the Software must retain the above copyright notice, this list of conditions
*    and the disclaimer and limitation of liability of Article 6, below. Your redistributions in object code form must reproduce 
*    the above copyright notice, this list of conditions and the disclaimer of Article 6 in the documentation and/or other materials
*    provided with the distribution, if any. 
* 2. Your end-user documentation included with the redistribution, if any, must include the following acknowledgment: "This 
*    product includes software developed by SAIC and the National Cancer Institute." If You do not include such end-user 
*    documentation, You shall include this acknowledgment in the Software itself, wherever such third-party acknowledgments 
*    normally appear.
* 3. You may not use the names "The National Cancer Institute", "NCI" "Science Applications International Corporation" and 
*    "SAIC" to endorse or promote products derived from this Software. This License does not authorize You to use any 
*    trademarks, service marks, trade names, logos or product names of either NCI or SAIC, except as required to comply with
*    the terms of this License. 
* 4. For sake of clarity, and not by way of limitation, You may incorporate this Software into Your proprietary programs and 
*    into any third party proprietary programs. However, if You incorporate the Software into third party proprietary 
*    programs, You agree that You are solely responsible for obtaining any permission from such third parties required to 
*    incorporate the Software into such third party proprietary programs and for informing Your sublicensees, including 
*    without limitation Your end-users, of their obligation to secure any required permissions from such third parties 
*    before incorporating the Software into such third party proprietary software programs. In the event that You fail 
*    to obtain such permissions, You agree to indemnify NCI for any claims against NCI by such third parties, except to 
*    the extent prohibited by law, resulting from Your failure to obtain such permissions. 
* 5. For sake of clarity, and not by way of limitation, You may add Your own copyright statement to Your modifications and 
*    to the derivative works, and You may provide additional or different license terms and conditions in Your sublicenses 
*    of modifications of the Software, or any derivative works of the Software as a whole, provided Your use, reproduction, 
*    and distribution of the Work otherwise complies with the conditions stated in this License.
* 6. THIS SOFTWARE IS PROVIDED "AS IS," AND ANY EXPRESSED OR IMPLIED WARRANTIES, (INCLUDING, BUT NOT LIMITED TO, 
*    THE IMPLIED WARRANTIES OF MERCHANTABILITY, NON-INFRINGEMENT AND FITNESS FOR A PARTICULAR PURPOSE) ARE DISCLAIMED. 
*    IN NO EVENT SHALL THE NATIONAL CANCER INSTITUTE, SAIC, OR THEIR AFFILIATES BE LIABLE FOR ANY DIRECT, INDIRECT, 
*    INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE 
*    GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF 
*    LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT 
*    OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
* 
*/

/**
 * @author CGEMS Team
 * @version 1.0
 */



/**
	* TestClient.java demonstartes various ways to execute searches with and without
      * using Application Service Layer (convenience layer that abstracts building criteria
      * Uncomment different scenarios below to demonstrate the various types of searches
*/

public class TestClient {
	public static void main(String[] args) {

		System.out.println("*** TestClient...");

		try{
				searchStudy();
				searchSNPPanel();
				searchSNPAssociationAnalysis();
				searchSNPAnalysisGroup();
				searchPopulation();				
				searchSpecimen();
				searchSNPAnnoation();
				searchSNPAssociationFinding();
				searchSNPFrequencyFinding();
				searchGeneBiomarker();
				searchSNPAssay();
				
			} catch (RuntimeException e) {
				e.printStackTrace();
				System.out.println("Test client throws Exception = "+ e);
			}
	}

	private static void searchSNPPanel(){

		SNPPanel snpPanel = new SNPPanel();
		try {
				System.out.println("______________________________________________________________________");
				System.out.println("Retrieving all SNPPanels...");
				ApplicationService appService = ApplicationServiceProvider.getApplicationService();
				
				List resultList = appService.search(SNPPanel.class, snpPanel);
				if(resultList != null){
					System.out.println("Number of results returned: " + resultList.size());
					for (Iterator resultsIterator = resultList.iterator(); resultsIterator.hasNext();) {
						SNPPanel returnedObj = (SNPPanel) resultsIterator.next();
						System.out.println(
								"Panel Name: "+returnedObj.getName()+"\n"+
								"Description: "+returnedObj.getDescription()+"\n"+
								"Technology: "+returnedObj.getTechnology()+"\n"+
								"Vendor: "+returnedObj.getVendor()+"\n"+
								"Vendor PanelId: "+returnedObj.getVendorPanelId()+"\n"+
								"Version: "+returnedObj.getVersion()+"\n");
					}
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static void searchSNPAssociationAnalysis(){

		SNPAssociationAnalysis snpAnalysis = new SNPAssociationAnalysis();
		try {
				System.out.println("______________________________________________________________________");
				System.out.println("Retrieving all SNPAssociationAnalysis...");
				ApplicationService appService = ApplicationServiceProvider.getApplicationService();
			
				List resultList = appService.search(SNPAssociationAnalysis.class, snpAnalysis);
				if(resultList != null){
					System.out.println("Number of results returned: " + resultList.size());
					for (Iterator resultsIterator = resultList.iterator(); resultsIterator.hasNext();) {
						SNPAssociationAnalysis returnedObj = (SNPAssociationAnalysis) resultsIterator.next();
						System.out.println(
								"Name: "+returnedObj.getName()+"\n"+
								"Description: "+returnedObj.getDescription()+"\n"+
								"Methods: "+returnedObj.getMethods()+"\n");
					}
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static void searchStudy(){

		Study study = new Study();
		try {
				System.out.println("______________________________________________________________________");
				System.out.println("Retrieving all Study objects...");
				ApplicationService appService = ApplicationServiceProvider.getApplicationService();
			
				List resultList = appService.search(Study.class, study);
				if(resultList != null){
					System.out.println("Number of results returned: " + resultList.size());
					for (Iterator resultsIterator = resultList.iterator(); resultsIterator.hasNext();) {
						Study returnedObj = (Study) resultsIterator.next();
						System.out.println(
								"Name: "+returnedObj.getName()+"\n"+
								"Description: "+returnedObj.getDescription()+"\n"+
								"SponsorStudyIdentifier: "+returnedObj.getSponsorStudyIdentifier());
					}
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static void searchSNPAnalysisGroup(){

		SNPAnalysisGroup snpAnalysisGroup = new SNPAnalysisGroup();
		try {
				System.out.println("______________________________________________________________________");
				System.out.println("Retrieving all SNPAnalysisGroup...");
				ApplicationService appService = ApplicationServiceProvider.getApplicationService();
			
				List resultList = appService.search(SNPAnalysisGroup.class, snpAnalysisGroup);
				if(resultList != null){
					System.out.println("Number of results returned: " + resultList.size());
					for (Iterator resultsIterator = resultList.iterator(); resultsIterator.hasNext();) {
						SNPAnalysisGroup returnedObj = (SNPAnalysisGroup) resultsIterator.next();
						System.out.println(
								"Name: "+returnedObj.getName()+"\n"+
								"Description: "+returnedObj.getDescription()+"\n");
					}
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static void searchSpecimen(){

		Specimen specimen = new Specimen();
		specimen.setSpecimenIdentifier("2427");
		try {
				System.out.println("______________________________________________________________________");
				System.out.println("Retrieving Specimen object based on Specimen Id");
				ApplicationService appService = ApplicationServiceProvider.getApplicationService();
			
				List resultList = appService.search(Specimen.class, specimen);
				if(resultList != null){
					System.out.println("Number of results returned: " + resultList.size());
					for (Iterator resultsIterator = resultList.iterator(); resultsIterator.hasNext();) {
						Specimen returnedObj = (Specimen) resultsIterator.next();
						System.out.println(
								"SpecimenIdentifier: "+returnedObj.getSpecimenIdentifier()+"\n"+
								"MaterialType: "+returnedObj.getMaterialType()+"\n"	);
					}
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static void searchPopulation(){

		Population population = new Population();
		try {
				System.out.println("______________________________________________________________________");
				System.out.println("Retrieving all Population types");
				ApplicationService appService = ApplicationServiceProvider.getApplicationService();
			
				List resultList = appService.search(Population.class, population);
				if(resultList != null){
					System.out.println("Number of results returned: " + resultList.size());
					for (Iterator resultsIterator = resultList.iterator(); resultsIterator.hasNext();) {
						Population returnedObj = (Population) resultsIterator.next();
						System.out.println(
								"Name: "+returnedObj.getName()+"\n"+
								"Description: "+returnedObj.getDescription()+"\n"+
								"Source: "+returnedObj.getSource()+"\n");
					}
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings("unchecked")
	private static void searchSNPAssociationFinding(){
		Collection geneBiomarkerCollection = new ArrayList();
		GeneBiomarker wt1 = new GeneBiomarker();
		wt1.setHugoGeneSymbol("WT1");
		geneBiomarkerCollection.add(wt1);
		
		SNPAnnotation snpAnnotation = new SNPAnnotation();
		snpAnnotation.setGeneBiomarkerCollection(geneBiomarkerCollection);
		try {
			System.out.println("______________________________________________________________________");
			System.out.println("Retrieving all SNPAssiciationFindings for WT1");
			ApplicationService appService = ApplicationServiceProvider.getApplicationService();
		
			List resultList = appService.search(SNPAssociationFinding.class, snpAnnotation);
			if(resultList != null){
				System.out.println("Number of results returned: " + resultList.size());
				System.out.println(
						"DbsnpId"+"\t"+
						"ChromosomeName"+"\t"+
						"ChromosomeLocation"+"\t"+
						"GenomeBuild"+"\t"+
						"ReferenceSequence"+"\t"+
						"ReferenceStrand"+"\t"+
						"GeneBiomarker(s)"+"\t"+
						"Analysis Name"+"\t"+
						"p-Value"+"\t"+
						"rank"+"\n");
				for (Iterator resultsIterator = resultList.iterator(); resultsIterator.hasNext();) {
					SNPAssociationFinding returnedObj = (SNPAssociationFinding) resultsIterator.next();
					System.out.println(
									returnedObj.getSnpAnnotation().getDbsnpId()+"\t"+
									returnedObj.getSnpAnnotation().getChromosomeName()+"\t"+
									returnedObj.getSnpAnnotation().getChromosomeLocation()+"\t"+
									pipeGeneBiomarkers(returnedObj.getSnpAnnotation().getGeneBiomarkerCollection())+"\t"+
									returnedObj.getSnpAssociationAnalysis().getName()+"\t"+
									returnedObj.getPvalue()+"\t"+
									returnedObj.getRank()+"\n");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings("unused")
	private static void searchSNPAnnoation(){		
		/*
		 * This example demonstrates the use of Hibernate detached criteria objects to formulate
		 * and perform more sophisticated searches. A detailed description of
		 * detached criteria is beyond the scope of this example; for more information, please
		 * consult the Hibernate documentation at
		 * http://www.hibernate.org/hib_docs/v3/api/org/hibernate/criterion/DetachedCriteria.html
		 * 
		 */
		
		DetachedCriteria criteria = DetachedCriteria.forClass(SNPAnnotation.class);
		criteria.add(Restrictions.ge("chromosomeLocation", new Integer(4000000)));
		criteria.add(Restrictions.le("chromosomeLocation", new Integer(4200000)));
		criteria.add(Restrictions.eq("chromosomeName", "1"));
		try {
			System.out.println("______________________________________________________________________");
			System.out.println("Retrieving all SNPAnnotations for Chr 1,4000000 - 4200000");
			ApplicationService appService = ApplicationServiceProvider.getApplicationService();
		

			List resultList = appService.query(criteria,SNPAnnotation.class.getName());
			if(resultList != null){
				System.out.println("Number of results returned: " + resultList.size());
				System.out.println(
						"DbsnpId"+"\t"+
						"ChromosomeName"+"\t"+
						"ChromosomeLocation"+"\t"+
						"GenomeBuild"+"\t"+
						"ReferenceSequence"+"\t"+
						"ReferenceStrand"+"\t"+
						"GeneBiomarker(s)"+"\n");
				for (Iterator resultsIterator = resultList.iterator(); resultsIterator.hasNext();) {
					SNPAnnotation returnedObj = (SNPAnnotation) resultsIterator.next();
					System.out.println(
									returnedObj.getDbsnpId()+"\t"+
									returnedObj.getChromosomeName()+"\t"+
									returnedObj.getChromosomeLocation()+"\t"+
									returnedObj.getGenomeBuild()+"\t"+
									returnedObj.getReferenceSequence()+"\t"+
									returnedObj.getReferenceStrand()+"\t"+
									pipeGeneBiomarkers(returnedObj.getGeneBiomarkerCollection())+"\n"
										);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings({"unused","unchecked"})
	private static void searchSNPAssay(){		
		SNPAnnotation snpAnnotation = new SNPAnnotation();
		snpAnnotation.setDbsnpId("rs5030335");
		
		SNPAssay snpAssay = new SNPAssay();
		snpAssay.setSnpAnnotation(snpAnnotation);
		try {
			System.out.println("______________________________________________________________________");
			System.out.println("Retrieving all SNPAssay objects for rs5030335");
			ApplicationService appService = ApplicationServiceProvider.getApplicationService();
		
			List resultList = appService.search(SNPAssay.class, snpAnnotation);
			if(resultList != null){
				System.out.println("Number of results returned: " + resultList.size());
				System.out.println(
						"Vender Assay ID"+"\t"+
						"DbsnpId"+"\t"+
						"ChromosomeName"+"\t"+
						"ChromosomeLocation"+"\t"+
						"SNP Panel"+"\t"+
						"Version"+"\t"+
						"DesignAlleles"+"\t"+
						"Status"+"\n");
				for (Iterator resultsIterator = resultList.iterator(); resultsIterator.hasNext();) {
					SNPAssay returnedObj = (SNPAssay) resultsIterator.next();
					System.out.println(
									returnedObj.getVendorAssayId()+"\t"+
									returnedObj.getSnpAnnotation().getDbsnpId()+"\t"+
									returnedObj.getSnpAnnotation().getChromosomeName()+"\t"+
									returnedObj.getSnpAnnotation().getChromosomeLocation()+"\t"+
									returnedObj.getSnpPanel().getName()+"\t"+
									returnedObj.getVersion()+"\t"+
									returnedObj.getDesignAlleles()+"\t"+
									returnedObj.getStatus()+"\t"+
									returnedObj.getDesignAlleles()+"\n"
									);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings({"unused","unchecked"})
	private static void searchSNPFrequencyFinding(){		
		Collection geneBiomarkerCollection = new ArrayList();
		GeneBiomarker wt1 = new GeneBiomarker();
		wt1.setHugoGeneSymbol("WT1");
		geneBiomarkerCollection.add(wt1);
		
		SNPAnnotation snpAnnotation = new SNPAnnotation();
		snpAnnotation.setGeneBiomarkerCollection(geneBiomarkerCollection);
		
		SNPFrequencyFinding snpFrequencyFinding = new SNPFrequencyFinding();
		snpFrequencyFinding.setSnpAnnotation(snpAnnotation);
		try {
			System.out.println("______________________________________________________________________");
			System.out.println("Retrieving all SNPFrequencyFinding objects for WT1");
			ApplicationService appService = ApplicationServiceProvider.getApplicationService();
		
			List resultList = appService.search(SNPFrequencyFinding.class, snpAnnotation);
			if(resultList != null){
				System.out.println("Number of results returned: " + resultList.size());
				System.out.println(
						"DbsnpId"+"\t"+
						"ChromosomeName"+"\t"+
						"ChromosomeLocation"+"\t"+
						"MinorAlleleFrequency"+"\t"+
						"HardyWeinbergPValue"+"\t"+
						"ReferenceAllele"+"\t"+
						"OtherAllele"+"\t"+
						"Population"+"\n");
				for (Iterator resultsIterator = resultList.iterator(); resultsIterator.hasNext();) {
					SNPFrequencyFinding returnedObj = (SNPFrequencyFinding) resultsIterator.next();
					System.out.println(
									returnedObj.getSnpAnnotation().getDbsnpId()+"\t"+
									returnedObj.getSnpAnnotation().getChromosomeName()+"\t"+
									returnedObj.getSnpAnnotation().getChromosomeLocation()+"\t"+
									returnedObj.getMinorAlleleFrequency()+"\t"+
									returnedObj.getHardyWeinbergPValue()+"\t"+
									returnedObj.getReferenceAllele()+"\t"+
									returnedObj.getOtherAllele()+"\t"+
									returnedObj.getPopulation().getName()+"\n"
									);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings({"unused","unchecked"})
	private static void searchGeneBiomarker(){	
		/*
		 * This example demonstrates the use of Hibernate detached criteria objects to formulate
		 * and perform more sophisticated searches. A detailed description of
		 * detached criteria is beyond the scope of this example; for more information, please
		 * consult the Hibernate documentation at
		 * http://www.hibernate.org/hib_docs/v3/api/org/hibernate/criterion/DetachedCriteria.html
		 * 
		 */
		
		DetachedCriteria criteria = DetachedCriteria.forClass(GeneBiomarker.class);
		criteria.add(Restrictions.gt("startPhyscialLocation", new Long(6000000)));
		criteria.add(Restrictions.lt("endPhysicalLocation", new Long(6300000)));
		criteria.add(Restrictions.eq("chromosome", "19"));
		
		try {
			System.out.println("______________________________________________________________________");
			System.out.println("Retrieving all GeneBiomarker objects for Chr 19,6000000 - 6300000");
			ApplicationService appService = ApplicationServiceProvider.getApplicationService();
		
			List resultList = appService.query(criteria,GeneBiomarker.class.getName());
			if(resultList != null){
				System.out.println("Number of results returned: " + resultList.size());
				System.out.println(
						"ChromosomeName"+"\t"+
						"StartPhyscialLocation"+"\t"+
						"EndPhysicalLocation"+"\t"+
						"HugoGeneSymbol"+"\n");
				for (Iterator resultsIterator = resultList.iterator(); resultsIterator.hasNext();) {
					GeneBiomarker returnedObj = (GeneBiomarker) resultsIterator.next();
					System.out.println(
									returnedObj.getChromosome()+"\t"+
									returnedObj.getStartPhyscialLocation()+"\t"+
									returnedObj.getEndPhysicalLocation()+"\t"+
									returnedObj.getHugoGeneSymbol()+"\n");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static String pipeGeneBiomarkers(Collection geneBiomarkerCollection)
	{
		String geneList = "";
		if(geneBiomarkerCollection != null)
		{
			for(Object object : geneBiomarkerCollection)
			{
				GeneBiomarker geneBiomarker = (GeneBiomarker) object;
				geneList = geneList + geneBiomarker.getHugoGeneSymbol() + "|";				
			}
			//remove Last |
			if(geneList.endsWith("|"))
			{
				geneList = geneList.substring(0,geneList.lastIndexOf("|"));
			}
		}
		return geneList;
	}
}
