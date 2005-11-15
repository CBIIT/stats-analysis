package gov.nih.nci.caintegrator.enumeration;

import java.io.Serializable;

public enum LinkageMethodType implements Serializable{
	Average{ 
        public String toString() 
        { 
            return "Average";
        } },
	Single{ 
        public String toString() 
        { 
            return "Single";
        } },
	Complete{ 
        public String toString() 
        { 
            return "Complete";
        } };
	}

