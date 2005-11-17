package gov.nih.nci.caintegrator.dto.query;

import gov.nih.nci.caintegrator.dto.de.ArrayPlatformDE;
import gov.nih.nci.caintegrator.dto.de.ExprFoldChangeDE;
import gov.nih.nci.caintegrator.dto.de.InstitutionDE;
import gov.nih.nci.caintegrator.dto.de.MultiGroupComparisonAdjustmentTypeDE;
import gov.nih.nci.caintegrator.dto.de.StatisticTypeDE;
import gov.nih.nci.caintegrator.dto.de.StatisticalSignificanceDE;

import java.util.Collection;

public interface ClassComparisonQueryDTO extends QueryDTO{

	public MultiGroupComparisonAdjustmentTypeDE getMultiGroupComparisonAdjustmentTypeDE();

	public void setMultiGroupComparisonAdjustmentTypeDE(
			MultiGroupComparisonAdjustmentTypeDE multiGroupComparisonAdjustmentTypeDE);

	public StatisticalSignificanceDE getStatisticalSignificanceDE();

	public void setStatisticalSignificanceDE(
			StatisticalSignificanceDE statisticalSignificanceDE);

	public StatisticTypeDE getStatisticTypeDE();

	public void setStatisticTypeDE(StatisticTypeDE statisticTypeDE);

	/**
	 * @return Returns the arrayPlatformDE.
	 */
	public ArrayPlatformDE getArrayPlatformDE();

	/**
	 * @param arrayPlatformDE The arrayPlatformDE to set.
	 */
	public void setArrayPlatformDE(ArrayPlatformDE arrayPlatformDE);

	/**
	 * @return Returns the exprFoldChangeDE.
	 */
	public ExprFoldChangeDE getExprFoldChangeDE();

	/**
	 * @param exprFoldChangeDE The exprFoldChangeDE to set.
	 */
	public void setExprFoldChangeDE(ExprFoldChangeDE exprFoldChangeDE);

	/**
	 * @return Returns the comparisonGroups.
	 */
	public Collection<ClinicalQueryDTO> getComparisonGroups();

	/**
	 * @param comparisonGroups The comparisonGroups to set.
	 */
	public void setComparisonGroups(
			Collection<ClinicalQueryDTO> comparisonGroups);
	
	public InstitutionDE getInstitutionDE();
	
	public void setInstitutionDE(InstitutionDE institutionDE);

}