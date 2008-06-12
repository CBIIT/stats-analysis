package gov.nih.nci.caintegrator.util;

import java.util.EventObject;

/**
 * Author: Ram Bhattaru
 * Date:   Jul 17, 2006
 * Time:   2:34:22 PM
 */
abstract public class DBEvent extends EventObject {
    public boolean completed ;

    final public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completedStatus) {
        this.completed = completedStatus;
    }
    public DBEvent(Object source) {
        super(source);
        completed = false;
    }

     public final static class GenotypeRetrieveEvent extends DBEvent {
        private final static String GENOTYPE_CRIT_EVENT = "GenotypeRetrieveEvent";
        public GenotypeRetrieveEvent() {
            super(GENOTYPE_CRIT_EVENT ) ;
        }
    }
}