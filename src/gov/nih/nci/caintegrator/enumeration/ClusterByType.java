package gov.nih.nci.caintegrator.enumeration;

import java.io.Serializable;

public enum ClusterByType implements Serializable{
	Genes{ 
        public String toString() 
        { 
            return "genes";
        } },
	Samples{ 
        public String toString() 
        { 
            return "samples";
        } };
}

