package com.hirehelpers.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hirehelpers.model.entity.HealthMonitor;
import com.hirehelpers.model.entity.Helper;
import com.hirehelpers.repository.HealthMonitorRepository;
import com.hirehelpers.repository.HelperRepository;


@RestController
public class HealthMonitorController {

    @Autowired
    HealthMonitorRepository repository;

    @RequestMapping(value = "/helpers/health", method = RequestMethod.GET)
    public List<HealthMonitor> getHealth() {
        return repository.findAll();
    }

    
}
