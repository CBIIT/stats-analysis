package gov.nih.nci.caintegrator.dto.query;

import gov.nih.nci.caintegrator.dto.de.ArrayPlatformDE;
import gov.nih.nci.caintegrator.dto.de.CloneIdentifierDE;
import gov.nih.nci.caintegrator.dto.de.ClusterTypeDE;
import gov.nih.nci.caintegrator.dto.de.DistanceMatrixTypeDE;
import gov.nih.nci.caintegrator.dto.de.GeneIdentifierDE;
import gov.nih.nci.caintegrator.dto.de.GeneVectorPercentileDE;
import gov.nih.nci.caintegrator.dto.de.InstitutionNameDE;
import gov.nih.nci.caintegrator.enumeration.LinkageMethodType;

import java.util.Collection;

public interface HierarchicalClusteringQueryDTO extends QueryDTO {

	/**
	 * @return Returns the arrayPlatformDE.
	 */
	public abstract ArrayPlatformDE getArrayPlatformDE();

	/**
	 * @param arrayPlatformDE The arrayPlatformDE to set.
	 */
	public abstract void setArrayPlatformDE(ArrayPlatformDE arrayPlatformDE);

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

	/**
	 * @return Returns the clusterTypeDE.
	 */
	public abstract ClusterTypeDE getClusterTypeDE();

	/**
	 * @param clusterTypeDE The clusterTypeDE to set.
	 */
	public abstract void setClusterTypeDE(ClusterTypeDE clusterTypeDE);

	/**
	 * @return Returns the distanceMatrixTypeDE.
	 */
	public abstract DistanceMatrixTypeDE getDistanceMatrixTypeDE();

	/**
	 * @param distanceMatrixTypeDE The distanceMatrixTypeDE to set.
	 */
	public abstract void setDistanceMatrixTypeDE(
			DistanceMatrixTypeDE distanceMatrixTypeDE);

	/**
	 * @return Returns the linkageMethodTypeDE.
	 */
	public abstract LinkageMethodType getLinkageMethodTypeDE();

	/**
	 * @param linkageMethodTypeDE The linkageMethodTypeDE to set.
	 */
	public abstract void setLinkageMethodTypeDE(
			LinkageMethodType linkageMethodTypeDE);

}