package com.spring.mvc.controller.user;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserDeleteController {

	//Passed
	@RequestMapping(value="/userdelete")
	public ModelAndView Home(HttpServletResponse response,  HttpSession session) throws IOException{
		return new ModelAndView("user/users");
	}
	
	
	
}
