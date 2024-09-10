package com.muhammad.microservices.limits_service.controllers;

import com.muhammad.microservices.limits_service.beans.Limit;
import com.muhammad.microservices.limits_service.configuration.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {
    private Configuration configuration;

    @Autowired
    public LimitsController(Configuration configuration) {
        this.configuration = configuration;
    }

    @GetMapping(path = "/limits")
    public Limit retrieveLimits(){
        return new Limit(configuration.getMinimum(), configuration.getMaximum());
    }

}
