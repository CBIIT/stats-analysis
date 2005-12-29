package gov.nih.nci.caintegrator.ui.graphing.util;

import org.jfree.chart.imagemap.ToolTipTagFragmentGenerator;

/**This class imlplements the tool tip generator and adds an id attribute to the
 * image map
 * @author rossok
 *
 */
public class RembrandtStandardToolTipTagFragmentGenerator implements ToolTipTagFragmentGenerator{
   
          public String generateToolTipFragment(String toolTipText) {
              String[] toolTipStrings = toolTipText.split(" "); 
              String idText = toolTipStrings[0];
              return " id=\"" + idText + "\" title=\"" + toolTipText + "\" alt=\"\"";
           }


}
