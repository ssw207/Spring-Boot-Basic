package com.green.myspringboot21.runner;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseRunner implements ApplicationRunner {
	@Autowired
	//spring-boot-starter-jdbc 의존성 등록시 자동으로 DataSource Bean등록
	DataSource dataSource;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("DataSource Bean 구현체 "+ dataSource.getClass().getName());
		try (Connection connection = dataSource.getConnection()) {
			System.out.println(connection.getMetaData().getURL());
			System.out.println(connection.getMetaData().getUserName());
		}
	}
}
