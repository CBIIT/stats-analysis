package gov.nih.nci.caintegrator.enumeration;

import java.awt.Color;


/**
 * Disease enumeration
 * 
 * @author harrismic
 *
 */
public enum DiseaseType {
	ASTROCYTOMA { Color getColor() {return Color.BLUE; }},
	GBM { Color getColor() {return Color.GREEN; }},
	MIXED { Color getColor() {return Color.MAGENTA; }},
	NON_TUMOR {Color getColor() {return Color.YELLOW; }},
	OLIGODENDROGLIOMA {Color getColor() {return Color.CYAN; }},
	UNCLASSIFIED {Color getColor() {return Color.GRAY; }},
	UNKNOWN {Color getColor() {return Color.DARK_GRAY; }};
	
	abstract Color getColor();
}


