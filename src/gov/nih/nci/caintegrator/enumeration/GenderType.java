package gov.nih.nci.caintegrator.enumeration;

import java.awt.Color;

public enum GenderType {
Male { Color getColor() { return Color.BLUE; }}, 
Female {Color getColor() { return Color.PINK; }},
Unknown {Color getColor() { return Color.DARK_GRAY; }};

abstract Color getColor();

}
