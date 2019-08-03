package com.adi.controller;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.adi.bean.ExchangeValue;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class CurrencyExchangeController {
	private Logger logger =LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Environment env;
	
//	@Autowired
//	private ExchnageRepository repo;
	
//	@Autowired
//	private SimpleExchangeValueSource exchangeValue;
	
	@GetMapping(path="/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveValue(@PathVariable String from, @PathVariable String to) {
		ExchangeValue value = new ExchangeValue(10L, "USD", "INR", BigDecimal.valueOf(65));
		value.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		//exchangeValue.publishExchangeChange("SAVE", conversionMultipleValue);
		logger.info("{}", value);
		return value;
	}
	
	@GetMapping(path="/currency-exchange-fail/from/{from}/to/{to}")
	@HystrixCommand(fallbackMethod = "hystrixFallBack")
	public ExchangeValue retrieveHystrixValue(@PathVariable String from, @PathVariable String to) {
		try {
			TimeUnit.MILLISECONDS.sleep(110000);
			ExchangeValue value = new ExchangeValue(10L, "USD", "INR", BigDecimal.valueOf(65));
			value.setPort(Integer.parseInt(env.getProperty("local.server.port")));
			return value;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public ExchangeValue hystrixFallBack(String from, String to) {
		ExchangeValue value = new ExchangeValue(10L, "USD", "INR", BigDecimal.valueOf(85));
		value.setPort(10000);
		return value;
	}
	
//	@PostMapping(value = "/currency-exchange/add")
//	public ResponseEntity<ExchangeValue> saveExchangeValue(@RequestBody ExchangeValue exchangeValue) {
//		exchangeValue.setAction("Add New Value");
//		return new ResponseEntity<ExchangeValue>(repo.save(exchangeValue), HttpStatus.CREATED);
//	}
	
//	@GetMapping(value = "/currency-exchange/{id}")
//	public ResponseEntity<Object> getExchangeValueById(@PathVariable Long id){
//		Optional<ExchangeValue> byId = repo.findById(id);
//		return new ResponseEntity<Object>(byId, HttpStatus.FOUND);
//	}

}
