package com.learning.microservices.currencyexchangeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;

@RestController
public class CurrencyExchangeConroller {

	@Autowired
	Environment environment;
	
	@Autowired
	CurrencyExchangeRepository currencyExchangeRepo;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue getConversionValue(@PathVariable String from, @PathVariable String to) {
		
		ExchangeValue conversionValue = currencyExchangeRepo.findByFromAndTo(from, to);
		
		logger.info("{}",conversionValue);

		return new ExchangeValue(conversionValue.getId(), from , to , conversionValue.getConversionMultiple(),
				Integer.parseInt(environment.getProperty("server.port")));
		
	}
}
