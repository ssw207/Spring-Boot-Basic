package com.green.myspringboot21.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/m/**")
		//반드시 m 다음에 / 을 주어야 한다.
		.addResourceLocations("classpath:/m/")
		.setCachePeriod(20);//20초
	}
}
