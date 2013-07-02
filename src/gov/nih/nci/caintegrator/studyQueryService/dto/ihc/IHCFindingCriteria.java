/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.caintegrator.studyQueryService.dto.ihc;

import gov.nih.nci.caintegrator.studyQueryService.dto.finding.SpecimenBasedMolecularFindingCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.protein.ProteinBiomarkerCriteia;
import gov.nih.nci.caintegrator.studyQueryService.finding.SpecimenBasedMolecularFindingHandler;

public abstract class IHCFindingCriteria extends SpecimenBasedMolecularFindingCriteria {
	private ProteinBiomarkerCriteia proteinBiomarkerCrit;	
	
	

	@Override
	public abstract SpecimenBasedMolecularFindingHandler getHandler() ;
	
	



	public ProteinBiomarkerCriteia getProteinBiomarkerCrit() {
		return proteinBiomarkerCrit;
	}



	public void setProteinBiomarkerCrit(ProteinBiomarkerCriteia proteinBiomarkerCrit) {
		this.proteinBiomarkerCrit = proteinBiomarkerCrit;
	}

	
	
}
