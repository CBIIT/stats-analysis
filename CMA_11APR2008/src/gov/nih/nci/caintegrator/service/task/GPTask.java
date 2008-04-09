package gov.nih.nci.caintegrator.service.task;

import gov.nih.nci.caintegrator.enumeration.FindingStatus;
import java.io.Serializable;

import org.apache.log4j.Logger;

/**
 * GPTask is the object used to identify a GenePattern job retured
 * from the GenePattern server.  For each genePattern session, the
 * job number number is unique, so each GPTask object is also unique.
 * @author rossok
 *
 */

public class GPTask implements Serializable{

	private static final long serialVersionUID = -7834720930549557557L;
    private static Logger logger = Logger.getLogger(GPTask.class);
    private String jobId;
    private String resultName;
    private FindingStatus status;
    private long elapsedTime;
    private long endTime;
    private long startTime;
    
    public GPTask(String jobId, String resultName, FindingStatus status){
        this.jobId = jobId;
        this.resultName = resultName;
        this.status = status;
        setStartTime(System.currentTimeMillis());
    }
    
    /**
     * @return Returns the status.
     */
    public FindingStatus getStatus() {
        return status;
    }
    /**
     * @param status The status to set.
     */
    public void setStatus(FindingStatus status) {
        this.status = status;
        switch(status) { 
        case Running:
            setStartTime(System.currentTimeMillis());
            break;
        case Error:
        case Completed:
            setEndTime(System.currentTimeMillis());
            break;
        default:
            logger.error("Uknown FindingState passed");
        }
    }

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getResultName() {
		return resultName;
	}

	public void setResultName(String resultName) {
		this.resultName = resultName;
	}
    /**
     * @param startTime The startTime to set.
     */
    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }
    /**
     * @return Returns the startTime.
     */
    public long getStartTime() {
        return startTime;
    }
    public long getElapsedTime() {
		return elapsedTime;
	}

	public void setElapsedTime(long elapsedTime) {
		this.elapsedTime = elapsedTime;
	}

	/**
     * @param endTime The endTime to set.
     */
    public void setEndTime(long endTime) {
        this.endTime = endTime;
        this.elapsedTime = this.endTime-this.startTime;
    }
    /**
     * @return Returns the endTime.
     */
    public long getEndTime() {
        return endTime;
    }
}
