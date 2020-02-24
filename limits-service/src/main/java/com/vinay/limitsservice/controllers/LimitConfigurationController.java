package com.vinay.limitsservice.controllers;

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
}
