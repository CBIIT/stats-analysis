/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.caintegrator.dto.critieria;

import gov.nih.nci.caintegrator.dto.de.ArrayPlatformDE;
import gov.nih.nci.caintegrator.dto.de.SegmentMeanDE;
import gov.nih.nci.caintegrator.enumeration.AnalysisType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author sahnih
 */



/**
* 
* 
*/

public class AnalysisTypeCriteria extends Criteria implements Serializable,
		Cloneable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6699829936759855656L;

	/**
	 * IMPORTANT! This class requires a clone method! This requires that any new
	 * data field that is added to this class also be cloneable and be added to
	 * clone calls in the clone method.If you do not do this, you will not
	 * seperate the references of at least one data field when we generate a
	 * copy of this object.This means that if the data field ever changes in one
	 * copy or the other it will affect both instances... this will be hell to
	 * track down if you aren't ultra familiar with the code base, so add those
	 * methods now! (Not necesary for primitives.)
	 */
	
	private AnalysisType analysisType = null;

	public AnalysisTypeCriteria(AnalysisType analysisType) {
		this.analysisType = analysisType;
	}



	public boolean isValid() {

		if (analysisType != null) {
			return true;
		}
		return false;
	}
	
	
	/**
	 * Overrides the protected Object.clone() method exposing it as public.
	 * It performs a 2 tier copy, that is, it does a memcopy of the instance
	 * and then sets all the non-primitive data fields to clones of themselves.
	 * 
	 * @return -A minimum 2 deep copy of this object.
	 */
	public Object clone() {
		AnalysisTypeCriteria myClone = null;
		myClone = (AnalysisTypeCriteria) super.clone();
		if(analysisType!=null) {
			myClone.analysisType =  analysisType;
		}
		return myClone;
	}



	/**
	 * @return the analysisType
	 */
	public AnalysisType getAnalysisType() {
		return analysisType;
	}



	/**
	 * @param analysisType the analysisType to set
	 */
	public void setAnalysisType(AnalysisType analysisType) {
		this.analysisType = analysisType;
	}

}
