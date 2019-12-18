package com.green.myspringboot21;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.green.myspringboot21.listener.MyStartingEvent;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		//SpringApplication.run(Application.class, args);
		SpringApplication application = new SpringApplication(Application.class);
		
		//banner off
		//application.setBannerMode(Mode.OFF);
		
		//리스너 등록
		application.addListeners(new MyStartingEvent()); // container생성전에 실행됨
		
		//WebApplication 타입 지정
		//application.setWebApplicationType(WebApplicationType.NONE); // Tomcat 동작하지 않음
		//application.setWebApplicationType(WebApplicationType.SERVLET); //spring MVC	서블릿 기반의 block IO 아키텍처. 요청당 쓰레드를 생성
		//application.setWebApplicationType(WebApplicationType.REACTIVE); //Spring Web Flux 기반 아키텍쳐로 변경
		
		//어플리케이션을 구동
		application.run(args);
	}

}
