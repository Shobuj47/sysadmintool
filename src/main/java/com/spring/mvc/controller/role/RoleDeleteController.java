package com.spring.mvc.controller.role;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ComponentScan(basePackages="com.spring.mvc")
public class RoleDeleteController {

	//Passed
	@RequestMapping(value="/roledelete")
	public ModelAndView Home(HttpServletResponse response) throws IOException{
		return new ModelAndView("roles");
	}
}
