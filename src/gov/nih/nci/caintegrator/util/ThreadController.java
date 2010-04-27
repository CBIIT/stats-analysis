package gov.nih.nci.caintegrator.util;

import java.util.List;
import java.util.Iterator;

/**
 * Author: Ram Bhattaru
 * Date:   Jul 17, 2006
 * Time:   3:03:30 PM
 */
public class ThreadController {
     private final static long SLEEP_TIME= 10;
    public static void sleepOnEvents(List eventList) throws InterruptedException {
        boolean sleep = true;
        do {
            Thread.sleep(SLEEP_TIME);
            sleep = false;
            for (Iterator iterator = eventList.iterator(); iterator.hasNext();) {
                DBEvent eventObj = (DBEvent)iterator.next();
                if (! eventObj.isCompleted()) {
                    sleep = true;
                    break;
                }
            }
        } while (sleep);

        return;
    }
}

