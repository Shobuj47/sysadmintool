package com.spring.mvc.controller.user;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserDeleteController {

	//Passed
	@RequestMapping(value="/userdelete")
	public ModelAndView Home(HttpServletResponse response) throws IOException{
		return new ModelAndView("user/users");
	}
	
	
	
}
