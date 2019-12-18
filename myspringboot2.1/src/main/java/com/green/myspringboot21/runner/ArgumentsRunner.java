package com.green.myspringboot21.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.green.myspringboot21.prop.PropProperties;

//SpringBoot 프로젝트가 시작될때 실행되는 클래스
@Component
public class ArgumentsRunner implements ApplicationRunner{
	@Value("${prop.name}")
	private String name;
	
	@Value("${prop.age}")
	private int age;
	
	@Autowired
	PropProperties properties;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// 프로젝트 run > run configuration의 args > 설정한 옵션들이 있는지를 확인
		log.debug("Program Args : " + args.containsOption("bar"));
		log.debug("jar Vm Args : " + args.containsOption("foo"));
		log.debug("application.properties name : "+name);
		log.debug("application.properties age : "+age);
		log.debug("property fullName "+properties.getFullName());
	}
}
