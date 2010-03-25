package gov.nih.nci.caintegrator.service.findings;

import java.util.List;
import java.util.Map;

public interface ReporterBasedFinding {
  public List<String> getReporterIds();
  
  public Map getReporterAnnotationsMap();
  public void setReporterAnnotationsMap(Map reporterResultsetMap);
	
}
