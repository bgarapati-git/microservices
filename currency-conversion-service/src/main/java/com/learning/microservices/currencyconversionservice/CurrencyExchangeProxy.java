package com.learning.microservices.currencyconversionservice;


import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//@FeignClient(name="currency-exchange-service", url="localhost:8000")
//@FeignClient(name="currency-exchange-service")
@FeignClient("NETFLIZ-ZUUL-GATEWAY-SERVER") //Tell the fein to communicate via API gatewey
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeProxy {
	
	//@RequestMapping("/currency-exchange/from/{from}/to/{to}")
	@RequestMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean getCurrencyExchangeValue(@PathVariable("from") String from,
			@PathVariable("to") String to);

}