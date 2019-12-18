package com.green.myspringboot21.listener;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyStartedEvent implements ApplicationListener<ApplicationStartedEvent> {
	@Override
	public void onApplicationEvent(ApplicationStartedEvent event) {
		System.out.println("ApplicationStarted 이벤트!!");
	}
}
