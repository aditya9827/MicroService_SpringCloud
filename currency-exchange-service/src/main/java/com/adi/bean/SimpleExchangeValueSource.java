package com.adi.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleExchangeValueSource {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
//	private Source source;
//	
//	@Autowired
//	public SimpleExchangeValueSource (Source source) {
//		this.source = source;
//	}
//	
//	public void publishExchangeChange(String action, BigDecimal conversionMultipleValue) {
//		logger.info("Sending Kafka Message -> {}, for change in conversoin multiple ->{}", action, conversionMultipleValue);
//		ExchangeValue exchangeValue = new ExchangeValue(action, conversionMultipleValue);
//		
//		source.output().send(MessageBuilder.withPayload(exchangeValue).build());
//		
//	}
	

}
