package com.muhammad.microservices.limits_service.controllers;

import com.muhammad.microservices.limits_service.beans.Limit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {

    @GetMapping(path = "/limits")
    public Limit retrieveLimits(){
        return new Limit(1,999);
    }

}
