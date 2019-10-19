package com.spring.mvc.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="com.spring.mvc")
public class RootConfig {

	@Bean
	public BasicDataSource getDataSource() {
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		bds.setUrl("jdbc:mysql://localhost:3306/sysadmintool");
		bds.setUsername("root");
		bds.setPassword("");
		bds.setMaxTotal(2);
		bds.setInitialSize(1);
		bds.setTestOnBorrow(true);
		bds.setValidationQuery("SELECT 1");
		bds.setDefaultAutoCommit(true);
		return bds;
	}
	
	
}
