package uk.co.arcotc.samples.springmvc;

import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import uk.co.arcotc.samples.springmvc.forms.SaveSampleRecordForm;
import uk.co.arcotc.samples.springmvc.model.SampleRecord;
import uk.co.arcotc.samples.springmvc.service.SampleService;

@Controller
public class SampleRecordJsonController {
	public static final String CONTROLLER_MAPPING_PREFIX = "/json/sample-record/";
	
	@Autowired private SampleService sampleService;
	
	@RequestMapping(value=CONTROLLER_MAPPING_PREFIX + "{name}", method=RequestMethod.GET)
	public ModelAndView find(@PathVariable("name") String name) {
		ModelAndView modelAndView = null;
		
		Map<String, String> response = new TreeMap<String, String>();
		response.put("intro", "hello");
		response.put("name", name);
		
		modelAndView = new ModelAndView("jsonView", "response", response);
		
		return modelAndView;
	}
	
	@RequestMapping(value=CONTROLLER_MAPPING_PREFIX, method=RequestMethod.POST)
	public ModelAndView save(SaveSampleRecordForm sampleRecordForm) {
		ModelAndView modelAndView = null;
		
		SampleRecord sampleRecord = sampleService.saveSampleRecord(sampleRecordForm.getName());
		
		modelAndView = new ModelAndView("jsonView", "response", CONTROLLER_MAPPING_PREFIX + sampleRecord.getKey());
		
		return modelAndView;
	}
}
