package gov.nih.nci.caintegrator.enumeration;

import java.io.Serializable;

public enum DistanceMatrixType implements Serializable {
	Correlation{ 
        public String toString() 
        { 
            return "Correlation";
        } },
	Euclidean{ 
        public String toString() 
        { 
            return "Euclidean";
        } };
	}

