package com.learning.microservices.limitsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.microservices.limitsservice.bean.LimitConfiguration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController

public class LimitsServiceController {

	@Autowired
	private Configuration config;
	
	@RequestMapping("/limits")
	public LimitConfiguration getLimitsConfiguration() {
		return new LimitConfiguration(config.getMinLimit(), config.getMaxLimit());
	}
	
	@RequestMapping("/fault-tolerance")
	@HystrixCommand(fallbackMethod = "defaultMessage" )
	public LimitConfiguration getLimitsConfig() {
		//return new LimitConfiguration(config.getMinLimit(), config.getMaxLimit());
		throw new RuntimeException();
	}
	
	public LimitConfiguration defaultMessage() {
		return new LimitConfiguration(9, 999);
	}
	
}
