package gov.nih.nci.caintegrator.studyQueryService.dto.germline;

/**
 /**
  * Author: Ram Bhattaru
  * Date:   Jul 21, 2006
  * Time:   5:08:50 PM
  */
public class AnalysisGroupCriteria {

    private String[] names;
    
    public AnalysisGroupCriteria(Long studyId) {
        this.studyId = studyId;
    }

    public String[] getNames() {
        return names;
    }

    public void setNames(String[] names) {
        this.names = names;
    }
     private Long studyId;
     
 	/**
 	 * @return Returns the studyId.
 	 */
 	public Long getStudyId() {
 		return studyId;
 	}

 	/**
 	 * @param studyId The studyId to set.
 	 */
 	public void setStudyId(Long studyId) {
 		this.studyId = studyId;
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