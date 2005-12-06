package gov.nih.nci.caintegrator.enumeration;

import java.awt.Color;

public enum GenderType {
M { Color getColor() { return Color.BLUE; }}, 
F {Color getColor() { return Color.PINK; }},
O {Color getColor() { return Color.DARK_GRAY; }};

abstract Color getColor();

}
