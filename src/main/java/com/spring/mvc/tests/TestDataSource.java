package com.spring.mvc.tests;

import javax.sql.DataSource;
import com.spring.mvc.config.RootConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestDataSource {
	public static void main(String args[]) {
//		ApplicationContext appCtg  = new AnnotationConfigApplicationContext(RootConfig.class);
//		DataSource ds = appCtg.getBean(DataSource.class);
//		JdbcTemplate jdbct = new JdbcTemplate(ds);
//		String sql = "INSERT INTO `sysadmintool`.`rolefunctioncodes` (`roleid`, `funcid`, `createdby`, `updatedby`)	VALUES (?,?,?,?);";
//		Object[] param = new Object[] {"1","1","1","1"};
//		jdbct.update(sql, param);
//		System.out.println("SQL Executed");
	}
}
