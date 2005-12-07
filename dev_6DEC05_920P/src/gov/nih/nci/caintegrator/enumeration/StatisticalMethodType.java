package gov.nih.nci.caintegrator.enumeration;

import java.io.Serializable;

public enum StatisticalMethodType implements Serializable{ 
	    TTest { 
		public String toString() 
		{ 
			return "T-Test:Two Sample Test";
		}},
       	Wilcoxin { 
		public String toString() 
		{ 
			return "Wilcoxin Test:Mann-Whitney Test";
		} }
	};

