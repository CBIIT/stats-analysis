package gov.nih.nci.caintegrator.dto.query;

import gov.nih.nci.caintegrator.dto.de.ArrayPlatformDE;
import gov.nih.nci.caintegrator.dto.de.CloneIdentifierDE;
import gov.nih.nci.caintegrator.dto.de.GeneIdentifierDE;
import gov.nih.nci.caintegrator.dto.de.GeneVectorPercentileDE;
import gov.nih.nci.caintegrator.dto.de.InstitutionNameDE;

import java.util.Collection;

public interface PrincipleComponentAnalysisQueryDTO extends QueryDTO {

	/**
	 * @return Returns the arrayPlatformDE.
	 */
	public abstract ArrayPlatformDE getArrayPlatformDE();

	/**
	 * @param arrayPlatformDE The arrayPlatformDE to set.
	 */
	public abstract void setArrayPlatformDE(ArrayPlatformDE arrayPlatformDE);

	/**
	 * @return Returns the comparisonGroup.
	 */
	public abstract ClinicalQueryDTO getComparisonGroup();

	/**
	 * @param comparisonGroup The comparisonGroup to set.
	 */
	public abstract void setComparisonGroup(ClinicalQueryDTO comparisonGroup);

	/**
	 * @return Returns the institutionNameDE.
	 */
	public abstract InstitutionNameDE getInstitutionNameDE();

	/**
	 * @param institutionNameDE The institutionNameDE to set.
	 */
	public abstract void setInstitutionNameDE(
			InstitutionNameDE institutionNameDE);

	/**
	 * @return Returns the geneIdentifierDEs.
	 */
	public abstract Collection<GeneIdentifierDE> getGeneIdentifierDEs();

	/**
	 * @param geneIdentifierDEs The geneIdentifierDEs to set.
	 */
	public abstract void setGeneIdentifierDEs(
			Collection<GeneIdentifierDE> geneIdentifierDEs);

	/**
	 * @return Returns the geneVectorPercentileDE.
	 */
	public abstract GeneVectorPercentileDE getGeneVectorPercentileDE();

	/**
	 * @param geneVectorPercentileDE The geneVectorPercentileDE to set.
	 */
	public abstract void setGeneVectorPercentileDE(
			GeneVectorPercentileDE geneVectorPercentileDE);

	/**
	 * @return Returns the reporterIdentifierDEs.
	 */
	public abstract Collection<CloneIdentifierDE> getReporterIdentifierDEs();

	/**
	 * @param reporterIdentifierDEs The reporterIdentifierDEs to set.
	 */
	public abstract void setReporterIdentifierDEs(
			Collection<CloneIdentifierDE> reporterIdentifierDEs);

}