package uk.co.arcotc.samples.springmvc.repository;

import javax.jdo.PersistenceManager;

import uk.co.arcotc.samples.springmvc.model.SampleRecord;

public class SampleRepositoryImpl implements SampleRepository {

	@Override
	public SampleRecord saveSampleRecord(String name) {
		SampleRecord sampleRecord = new SampleRecord(name);
		
		PersistenceManager pm = PersistenceManagerFactoryManager.get().getPersistenceManager();
        try {
            pm.makePersistent(sampleRecord);
        } finally {
            pm.close();
        }
        
		return sampleRecord;
	}
}
