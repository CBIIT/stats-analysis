package gov.nih.nci.caintegrator.ui.graphing.util;

import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.imagemap.StandardToolTipTagFragmentGenerator;
import org.jfree.chart.imagemap.StandardURLTagFragmentGenerator;
import org.jfree.util.StringUtils;

public class ImageMapUtil {

	/**
	 * Same interface as ChartUtilities.writeImageMap. This version will find the 
	 * bounding rectangles for the entities in the ChartRenderingInfo object and will write those
	 * to the image map.
	 * @param writer
	 * @param name
	 * @param info
	 * @param useOverlibToolTip
	 */
	public static void writeBoundingRectImageMap(PrintWriter writer, String name, ChartRenderingInfo info, boolean useOverlibToolTip) {
	  EntityCollection collection = info.getEntityCollection();
      Collection entities = collection.getEntities();	
		
      Collection<ChartEntity> boundingEntities = getBoundingEntities(entities);
      writeBoundingRectImageMap(writer, name, boundingEntities, useOverlibToolTip);
		
	}
	
	/**
	 * Write the image map for the collection of bounding entities.
	 * @param writer
	 * @param name
	 * @param boundingEntities
	 * @param useOverlibToolTip
	 */
	private static void writeBoundingRectImageMap(PrintWriter writer, String name, Collection<ChartEntity> boundingEntities, boolean useOverlibToolTip) {
	  System.out.println("Num entities=" + boundingEntities.size());
	  StringBuffer sb = new StringBuffer();
      ChartEntity chartEntity;
      String areaTag;

      StandardToolTipTagFragmentGenerator ttg = new StandardToolTipTagFragmentGenerator();
      StandardURLTagFragmentGenerator urlg = new StandardURLTagFragmentGenerator();
      sb.append("<map id=\"" + name + "\" name=\"" + name + "\">");
	  sb.append(StringUtils.getLineSeparator());
      for (Iterator i=boundingEntities.iterator(); i.hasNext(); ) {
       	 chartEntity = (ChartEntity) i.next();
       	 areaTag = chartEntity.getImageMapAreaTag(ttg, urlg).trim();
   	     if (areaTag.length() > 0) {
           sb.append(chartEntity.getImageMapAreaTag(ttg, urlg));
           sb.append(StringUtils.getLineSeparator());
   	     }
      }
      sb.append("</map>");
      writer.println(sb.toString());
	}
    
    public static String returnBoundingRectImageMap(PrintWriter writer, String name,  boolean useOverlibToolTip,ChartRenderingInfo info) {
        EntityCollection collection = info.getEntityCollection();
        Collection entities = collection.getEntities(); 
        
        Collection<ChartEntity> myBoundingEntities = getBoundingEntities(entities);  
        
        System.out.println("Num entities=" + myBoundingEntities.size());
          StringBuffer sb = new StringBuffer();
          ChartEntity chartEntity;
          String areaTag;

          RembrandtStandardToolTipTagFragmentGenerator ttg = new RembrandtStandardToolTipTagFragmentGenerator();
          StandardURLTagFragmentGenerator urlg = new StandardURLTagFragmentGenerator();
          sb.append("<map id=\"" + name + "\" name=\"" + name + "\">");
          sb.append(StringUtils.getLineSeparator());
          for (Iterator i=myBoundingEntities.iterator(); i.hasNext(); ) {
             chartEntity = (ChartEntity) i.next();
             areaTag = chartEntity.getImageMapAreaTag(ttg, urlg).trim();
             if (areaTag.length() > 0) {
               sb.append(chartEntity.getImageMapAreaTag(ttg, urlg));
               sb.append(StringUtils.getLineSeparator());
             }
          }
          sb.append("</map>");
          return sb.toString();
        }
	
	/**
	 * Get a collection of entities with the area shape equal to the bounding rectangle
	 * for the shape of original entity. This is necessary because the Javascript for the sample 
	 * selection lasso can only handle rect objects.
	 * @param entities
	 * @return a collection of entities containing the bounding rectangles of the original entities
	 */
	private static Collection<ChartEntity> getBoundingEntities(Collection entities) {
	  ChartEntity entity;
	  ChartEntity boundingEntity;
	  Shape shape;
	  Rectangle2D boundingRect;
	  Collection<ChartEntity> boundingEntities = new ArrayList<ChartEntity>();
	  for (Iterator i=entities.iterator(); i.hasNext(); ) {
	     entity = (ChartEntity) i.next();
	     shape = entity.getArea();
	     boundingRect = shape.getBounds2D();
	     boundingEntity = new ChartEntity(boundingRect, entity.getToolTipText(), entity.getURLText());
	     boundingEntities.add(boundingEntity);
	  }
	  return boundingEntities;
	}

}
