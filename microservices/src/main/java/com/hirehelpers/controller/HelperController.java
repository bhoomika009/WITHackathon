package com.hirehelpers.controller;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hirehelpers.model.entity.HealthMonitor;
import com.hirehelpers.model.entity.Helper;
import com.hirehelpers.model.request.HealthMonitorRequest;
import com.hirehelpers.model.request.HelperRequest;
import com.hirehelpers.model.request.SearchByCategoryRequest;
import com.hirehelpers.model.response.HelperResponse;
import com.hirehelpers.repository.HealthCertificateRepository;
import com.hirehelpers.repository.HealthMonitorRepository;
import com.hirehelpers.repository.HelperRepository;


@RestController
public class HelperController {


    @Autowired
    HelperRepository repository;
    
    @Autowired
    HealthMonitorRepository healthMonitorRepository;

    @RequestMapping(value = "/helpers/search", method = RequestMethod.GET)
    public List<HelperResponse> searchHelpers(ModelMap model) {
    	List<HelperResponse> helperResponse = new ArrayList<HelperResponse>();
        List<Helper> helpers = repository.findAll();
        for (Helper helper : helpers) {
        	HelperResponse res = new HelperResponse();
        	res.setId(helper.getId());
        	res.setFname(helper.getFname());
        	res.setLname(helper.getLname());
        	res.setHireById(helper.getHireById());
        	res.setAadharNumber(helper.getAadharNumber());
        	res.setAddress(helper.getAddress());
        	res.setAgentId(helper.getAgentId());
        	res.setContactNumber(helper.getContactNumber());
        	res.setCategory(helper.getCategory());
        	res.setHired(helper.isHired());
        	helperResponse.add(res);
        }
        return helperResponse;
    }

    @RequestMapping(value = "/helpers/searchByCategory", method = RequestMethod.POST)
    public List<HelperResponse> searchHelpersByCategory(@RequestBody SearchByCategoryRequest searchByCategoryRequest) {
    	
    	List<String> categories = searchByCategoryRequest.getCategories();
    	
    	List<HelperResponse> helperResponse = new ArrayList<HelperResponse>();
        List<Helper> helpers = repository.findByCategory(categories);
        for (Helper helper : helpers) {
        	HelperResponse res = new HelperResponse();
        	res.setId(helper.getId());
        	res.setFname(helper.getFname());
        	res.setLname(helper.getLname());
        	res.setHireById(helper.getHireById());
        	res.setAadharNumber(helper.getAadharNumber());
        	res.setAddress(helper.getAddress());
        	res.setAgentId(helper.getAgentId());
        	res.setContactNumber(helper.getContactNumber());
        	res.setCategory(helper.getCategory());
        	//res.setTemperature(helper.getHealthMonitor().getTemperature());
        	//res.setPulseRate(helper.getHealthMonitor().getPulseRate());
        	res.setHired(helper.isHired());
        	helperResponse.add(res);
        }
        return helperResponse;
    }
    
    @RequestMapping(value = "/user/helpers/{hireById}", method = RequestMethod.GET)
    public List<HelperResponse> getHelperDetailsHiredByUser(@PathVariable int hireById) {
    	
    	List<HelperResponse> helperResponse = new ArrayList<HelperResponse>();
        List<Helper> helpers = repository.findByHireById(hireById);
        for (Helper helper : helpers) {
        	HelperResponse res = new HelperResponse();
        	res.setId(helper.getId());
        	res.setFname(helper.getFname());
        	res.setLname(helper.getLname());
        	res.setHireById(helper.getHireById());
        	res.setAadharNumber(helper.getAadharNumber());
        	res.setAddress(helper.getAddress());
        	res.setAgentId(helper.getAgentId());
        	res.setContactNumber(helper.getContactNumber());
        	res.setCategory(helper.getCategory());
        	
        	List<HealthMonitor> healthMonitor =   healthMonitorRepository.findByHelperId(helper.getId());
        	res.setTemperature(healthMonitor.get(0).getTemperature());
        	res.setPulseRate(healthMonitor.get(0).getPulseRate());
        	res.setHired(helper.isHired());
        	helperResponse.add(res);
        }
        return helperResponse;
    }
       
    	
    @PostMapping("/helpers/add")
    public Helper resgiterAgent(@Valid @RequestBody HelperRequest helperRequest)
    {
    	Helper helper = new Helper();
    	helper.setFname(helperRequest.getFname());
    	helper.setLname(helperRequest.getLname());
    	helper.setAddress(helperRequest.getAddress());
    	helper.setContactNumber(helperRequest.getContactNumber());
    	helper.setAadharNumber(helperRequest.getAadharNumber());
    	helper.setCategory(helperRequest.getCategory());
    	helper.setAgentId(helperRequest.getAgentId());
    	
    	HealthMonitor healthMonitor = new HealthMonitor();
    	healthMonitor.setTemperature(helperRequest.getTemperature());
    	healthMonitor.setPulseRate(helperRequest.getPulseRate());
    	
    	//helper.setHealthMonitor(healthMonitor);
        return repository.save(helper);
    }
    
    @PostMapping("/health/update")
    public HealthMonitor updateHelperHealth(@Valid @RequestBody HealthMonitorRequest healthMonitorRequest)
    {
    	HealthMonitor healthMonitor = new HealthMonitor();
    	healthMonitor.setHelperId(healthMonitorRequest.getHelperId());
    	healthMonitor.setTemperature(healthMonitorRequest.getTemperature());
    	healthMonitor.setPulseRate(healthMonitorRequest.getPulseRate());
    	  	
    	 healthMonitorRepository.updateHealth(healthMonitorRequest.getTemperature(),
    			healthMonitorRequest.getPulseRate(), healthMonitor.getHelperId());
    	 
    	 return healthMonitorRepository.findByHelperId(healthMonitorRequest.getHelperId()).get(0);
    }

    @PostMapping("/health/add")
    public HealthMonitor addHealth(@Valid @RequestBody HealthMonitorRequest healthMonitorRequest)
    {
    	HealthMonitor healthMonitor = new HealthMonitor();
    	healthMonitor.setHelperId(healthMonitorRequest.getHelperId());
    	healthMonitor.setTemperature(healthMonitorRequest.getTemperature());
    	healthMonitor.setPulseRate(healthMonitorRequest.getPulseRate());
    	  	
    	     	 
    	 return healthMonitorRepository.save(healthMonitor);
    }

	@RequestMapping("/helpers/hire/{userId}/{helperId}")
	public ResponseEntity<String> hireHelper(@PathVariable int helperId, @PathVariable int userId)
	{
		List<Helper> helper =repository.findById(helperId);  	

		if(helper.size()>0){
			Helper updateHelper = helper.get(0);
			if(updateHelper.isHired()){
				System.out.println("Helper already hired");
				return new ResponseEntity<String>("Already Hired", new HttpHeaders(), HttpStatus.FOUND);
			}
			else{
				System.out.println("Helper not hired, do update");
				updateHelper.setHireById(userId);
				updateHelper.setHired(true);
				updateHelper.setHireDate(new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()));
				repository.save(updateHelper);
				return new ResponseEntity<String>("Hired", new HttpHeaders(), HttpStatus.OK);
			}	
		}else{
			System.out.println("Helper doesn't exists");
			return new ResponseEntity<String>("Helper doesn't Exists", new HttpHeaders(), HttpStatus.NOT_FOUND);

		}  		
	}
}

