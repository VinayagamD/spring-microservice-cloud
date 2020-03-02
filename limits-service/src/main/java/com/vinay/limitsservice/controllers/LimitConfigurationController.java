package com.vinay.limitsservice.controllers;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.vinay.limitsservice.bean.LimitsConfiguration;
import com.vinay.limitsservice.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/limits")
public class LimitConfigurationController {

    private final Configuration configuration;

    public LimitConfigurationController(Configuration configuration) {
        this.configuration = configuration;
    }

    @GetMapping
    public LimitsConfiguration retrieveLimitsFromConfiguration(){
        return new LimitsConfiguration(configuration.getMaximum(), configuration.getMinimum());
    }

    @GetMapping("/fault-tolerance-example")
    @HystrixCommand(fallbackMethod = "fallbackRetrieveConfiguration")
    public LimitsConfiguration retrieveConfiguration(){
        throw new RuntimeException("Not Available");
    }

    public LimitsConfiguration fallbackRetrieveConfiguration(){
        return  new LimitsConfiguration(9, 999);
    }
}
