package gov.nih.nci.caintegrator.enumeration;

import java.awt.Color;


/**
 * Disease enumeration
 * 
 * @author harrismic
 *
 */
public enum DiseaseType {
	ASTROCYTOMA { public Color  getColor() {return Color.BLUE; }},
	GBM { public Color getColor() {return Color.GREEN; }},
	MIXED { public Color getColor() {return Color.MAGENTA; }},
	NON_TUMOR {public Color getColor() {return Color.YELLOW; }},
	OLIGODENDROGLIOMA {public Color getColor() {return Color.CYAN; }},
	UNCLASSIFIED {public Color getColor() {return Color.GRAY; }},
	UNKNOWN {public Color getColor() {return Color.DARK_GRAY; }};
	
	public abstract Color getColor();
}


