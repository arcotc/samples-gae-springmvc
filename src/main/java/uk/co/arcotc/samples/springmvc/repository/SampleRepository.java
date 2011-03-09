package uk.co.arcotc.samples.springmvc.repository;

import uk.co.arcotc.samples.springmvc.model.SampleRecord;

public interface SampleRepository {

	public SampleRecord saveSampleRecord(String name);

}
