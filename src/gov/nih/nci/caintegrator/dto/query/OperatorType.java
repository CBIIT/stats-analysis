/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

/*
 *  @author: SahniH
 *  Created on Sep 24, 2004
 *  @version $ Revision: 1.0 $
 * 
 */
package gov.nih.nci.caintegrator.dto.query;

import java.io.Serializable;


/**
 * @author SahniH,BauerD
 * Date: Sep 24, 2004
 * 
 */


/**
* 
* 
*/

public class OperatorType implements Serializable,Cloneable{
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
    private String operatorType;
    public final static Intersection AND = new Intersection();
    public final static Union OR = new Union ();
    public final static Difference NOT = new Difference ();
    public final static ProjectResultsBy PROJECT_RESULTS_BY = new ProjectResultsBy ();
    
    private OperatorType(String operatorType) {
        this.operatorType = operatorType;
    }
    public final static class Intersection extends OperatorType {
    	Intersection () {
             super("AND");
         }
    }
    public final static class Union extends OperatorType {
    	Union () {
            super("OR");
        }
    }
    public final static class Difference extends OperatorType {
    	Difference () {
            super("NOT");
        }
    }
    public final static class ProjectResultsBy extends OperatorType {
    	ProjectResultsBy () {
            super("PROJECT_RESULTS_BY");
        }
    }
	/**
	 * @return Returns the operatorType.
	 */
	public String getOperatorType() {
		return this.operatorType;
	}
	/**
	 * @param operatorType The operatorType to set.
	 */
	public void setOperatorType(String operatorType) {
		this.operatorType = operatorType;
	}
	/**
	 * Overrides the protected Object.clone() method exposing it as public.
	 * It performs a 2 tier copy, that is, it does a memcopy of the instance
	 * and then sets all the non-primitive data fields to clones of themselves.
	 * 
	 * @return -A minimum 2 deep copy of this object.
	 */
	public Object clone() {
		OperatorType myClone = null;
		try {
			myClone = (OperatorType)super.clone();
		} catch (CloneNotSupportedException e) {
			//This will never happen
		}
		return myClone;
	}
    
    public boolean equals(Object obj){
        boolean returnType = false;
        if(obj instanceof OperatorType){
            if(obj instanceof Intersection && this instanceof Intersection){
                returnType = true;
            }
            else if(obj instanceof ProjectResultsBy && this instanceof ProjectResultsBy){
                returnType = true;
            }
            else if(obj instanceof Union && this instanceof Union){
                returnType = true;
            }
            else if(obj instanceof Difference && this instanceof Difference){
                returnType = true;
            }
        }
        return returnType;
    }
}
