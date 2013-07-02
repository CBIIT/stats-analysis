/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.caintegrator.ui.graphing.util;

import org.jfree.chart.imagemap.ToolTipTagFragmentGenerator;

/**This class imlplements the tool tip generator and adds an id attribute to the
 * image map
 * @author rossok
 *
 */


/**
* 
* 
*/

public class CAIOverlibToolTipTagFragmentGenerator implements ToolTipTagFragmentGenerator{
   
          public String generateToolTipFragment(String toolTipText) {
              String[] toolTipStrings = toolTipText.split(" "); 
              String idText = toolTipStrings[0];
              //return " id=\"" + idText + "\" title=\"" + toolTipText + "\" alt=\"\"";
              
          	 
              return " id=\"" + idText + "\"  onMouseOver=\"return overlib('" + toolTipText 
              + "', CAPTION, 'Additional Info', FGCOLOR, '#FFFFFF', BGCOLOR, '#000000', WIDTH, 150, HEIGHT, 25);\" onMouseOut=\"return nd();\"";

          	  
           }


}
