package gov.nih.nci.caintegrator.studyQueryService.dto.germline;

/**
 /**
  * Author: Ram Bhattaru
  * Date:   Jul 21, 2006
  * Time:   5:08:50 PM
  */
public class AnalysisGroupCriteria {

    private String[] names;

    public String[] getNames() {
        return names;
    }

    public void setNames(String[] names) {
        this.names = names;
    }
     private String studyName;

    public String getStudyName() {
        return studyName;
    }

    public AnalysisGroupCriteria(String studyName) {
        this.studyName = studyName;
    }

    public void setStudyName(String studyName) {
        this.studyName = studyName;
    }

    @Override
	public String toString()
	{
		String str = "Analysis Groups\n";
		
		if ((names != null) && (names.length > 0))
		{
			for (String name : names)
			{
				str = str + name + "\n";
			}
		}
			
		return str;
	}
}