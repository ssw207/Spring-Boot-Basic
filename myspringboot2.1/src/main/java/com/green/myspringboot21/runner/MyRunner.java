package com.green.myspringboot21.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class MyRunner implements ApplicationRunner{
	@Autowired
	String env;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.info("현재 런타임 환경 : "+env);
	}

}
