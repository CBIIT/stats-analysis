package gov.nih.nci.caintegrator.enumeration;

public enum StatisticalMethodType { 
	TTest { 
		public String toString() 
		{ 
			return "T-Test:Two Sample Test";
		} },
	Wilcoxin { 
		public String toString() 
		{ 
			return "Wilcoxin Test:Mann-Whitney Test";
		} }
	};

