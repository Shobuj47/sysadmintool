package com.spring.mvc.tests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.spring.mvc.config.RootConfig;
import com.spring.mvc.services.pwdvault.PwdVaultServiceImpl;



@ComponentScan(basePackages="com.spring.mvc.*")
public class TestPwdvault {

	
	public static void main(String args[]) {
		ApplicationContext appCtg  = new AnnotationConfigApplicationContext(RootConfig.class);
		try {
		PwdVaultServiceImpl tt = appCtg.getBean(PwdVaultServiceImpl.class);
		String result = tt.resetPassword(1, "test", "7890");
		System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
