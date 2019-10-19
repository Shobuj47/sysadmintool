package com.spring.mvc.controller.common;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Controller
@ComponentScan(basePackages="com.spring.mvc")
public class DashboardController {

	
	@RequestMapping(value="/dashboard")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("common/dashboard");
	}
	
}
