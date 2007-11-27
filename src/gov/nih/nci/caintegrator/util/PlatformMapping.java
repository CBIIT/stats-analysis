package gov.nih.nci.caintegrator.util;

/**
 * 
 * @author caintegrator team
 * Contains all information for array platforms used in a study. The information
 * can later used in determining gene expression from a file or datastore.
 *
 */
public class PlatformMapping implements java.io.Serializable {
	
	private String platformName;
	private String displayString;
	private String center;
	private String dataType;
	/**
	 * change fileName variable to dataSetName (below) as to make more generic
	 */
	private String fileName;
	private String annotationFileName;
	private String arrayDesign;
	
	private int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCenter() {
		return center;
	}
	public void setCenter(String center) {
		this.center = center;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	
	public String getDisplayString() {
		return displayString;
	}
	public void setDisplayString(String displayString) {
		this.displayString = displayString;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getPlatformName() {
		return platformName;
	}
	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}
	public String getAnnotationFileName() {
		return annotationFileName;
	}
	public void setAnnotationFileName(String annotationFileName) {
		this.annotationFileName = annotationFileName;
	}
	public String getArrayDesign() {
		return arrayDesign;
	}
	public void setArrayDesign(String arrayDesign) {
		this.arrayDesign = arrayDesign;
	}
	
	
	
}
