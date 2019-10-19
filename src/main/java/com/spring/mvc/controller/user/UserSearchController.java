package com.spring.mvc.controller.user;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@ComponentScan(basePackages="com.spring.mvc")
public class UserSearchController {
	
	//Passed
	@RequestMapping(value="/users")
	public ModelAndView Home(HttpServletResponse response) throws IOException{
		return new ModelAndView("user/users");
	}
	
}
