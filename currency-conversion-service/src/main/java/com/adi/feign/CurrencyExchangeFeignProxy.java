package com.adi.feign;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.adi.bean.CurrencyConversionBean;

//Use this confgi when not using Ribbon
//@FeignClient(name="curreny-exchange-service", url = "http://localhost:8000")

//@FeignClient(name="curreny-exchange-service")
@FeignClient(name="netflix-zuul-api-gateway")
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeFeignProxy {
	
	@GetMapping(path="/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveValue(@PathVariable String from, @PathVariable String to);

}
