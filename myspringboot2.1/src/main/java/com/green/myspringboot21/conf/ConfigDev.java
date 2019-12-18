package com.green.myspringboot21.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration
public class ConfigDev {
	
	@Bean
	public String env() {
		return "개발환경 Bean";
	}
	
}
