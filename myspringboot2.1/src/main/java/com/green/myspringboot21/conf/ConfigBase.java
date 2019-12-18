package com.green.myspringboot21.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("prod")
@Configuration
public class ConfigBase {
	
	@Bean
	public String env() {
		return "운영환경 Bean";
	}
	
}
