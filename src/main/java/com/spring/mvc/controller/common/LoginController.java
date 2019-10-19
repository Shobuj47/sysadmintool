package com.spring.mvc.controller.common;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@ComponentScan(basePackages="com.spring.mvc")
public class LoginController {

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView getlogin(HttpServletResponse response) throws IOException{
		return new ModelAndView("home");
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView login(HttpServletResponse response) throws IOException{
		return new ModelAndView("common/dashboard");
	}
	
	
	
	@RequestMapping(value="/logout")
	public ModelAndView logout(HttpServletResponse response) throws IOException{
		return new ModelAndView("common/home");
	}
	
	
}
