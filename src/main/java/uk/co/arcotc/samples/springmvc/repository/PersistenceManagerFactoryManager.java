package uk.co.arcotc.samples.springmvc.repository;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

public class PersistenceManagerFactoryManager {
    private static final PersistenceManagerFactory pmfInstance =
        JDOHelper.getPersistenceManagerFactory("transactions-optional");

    private PersistenceManagerFactoryManager() {
    	// Empty - singleton
    }

    public static PersistenceManagerFactory get() {
        return pmfInstance;
    }
}