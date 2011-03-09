package uk.co.arcotc.samples.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;

import uk.co.arcotc.samples.springmvc.model.SampleRecord;
import uk.co.arcotc.samples.springmvc.repository.SampleRepository;

public class SampleServiceImpl implements SampleService {
	@Autowired private SampleRepository sampleRepository;
	
	@Override
	public SampleRecord saveSampleRecord(String name) {
		return sampleRepository.saveSampleRecord(name);
	}

}
