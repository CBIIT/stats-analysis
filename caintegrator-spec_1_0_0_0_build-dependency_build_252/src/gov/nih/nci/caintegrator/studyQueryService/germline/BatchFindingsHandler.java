package gov.nih.nci.caintegrator.studyQueryService.germline;


import java.util.List;
import java.util.Set;

import org.hibernate.Session;

/**
 * Author: Ram Bhattaru
 * Date:   Sep 25, 2006
 * Time:   4:49:24 AM
 */
abstract public class BatchFindingsHandler {

    /*
      1.  For Findings that are requested by regular start & end index with Annotations
          Criteria: start=0  end=end
      2.  For Findings that are requested by regular start & end index: wihtout Annotation
          Criteria: start=start  end=end
      3.  For Findings that are requested by calling populateFindings(). i.e. all Findings
          with Annotation Criteria (start: -1 end: -1)  meaning ignore indexes as it happens
          in a continuos loop
      3.  For Findings that are requested by calling populateFindings(). i.e. all Findings
          without Annotation Criteria (start: start  end: end)
    */

    public static final int BATCH_OBJECT_INCREMENT = 20000;

    protected static int IN_PARAMETERS  = 1000;

    protected abstract Set getConcreteTypedFindingSet() ;
    protected abstract List getConcreteTypedFindingList() ;

    final protected void populateCurrentResultSet(List findings, List toBePopulated, Session session) {

         /*  1. Remove the first 500 objects and add it to a new HashSet */
         Set toBeSent = getConcreteTypedFindingSet();
         int size = findings.size();
         for (int index = 0;  (index < size) && (index <= BATCH_OBJECT_INCREMENT); index++) {
             Object f =  findings.remove(0);
             toBeSent.add(f);
         }

         /* 2. Add results to toBePopulated after making sure it is empty */
         do {
            synchronized(toBePopulated) {
                   if (toBePopulated.size() == 0)  {
                       toBePopulated.add(toBeSent);
                       session.clear();
                       break;
                   }
            }
            try {
                 Thread.currentThread().sleep(10);
            } catch (InterruptedException e) {
                  e.printStackTrace(); // no big deal
            }
         } while (true);
       }

    final protected  void process(List toBePopulated, Set toBeSent, Session session) {
         /*  Add results to toBePopulated after making sure it is empty */
         while (true) {
             synchronized(toBePopulated) {
                 if (toBePopulated.size() == 0)  {
                     toBePopulated.add(toBeSent);
                     session.clear();
                     break;
                 }
             }
             try {
                  Thread.currentThread().sleep(10);
             } catch (InterruptedException e) {
                    e.printStackTrace(); // no big deal
             }
         }
         return;
     }

}
