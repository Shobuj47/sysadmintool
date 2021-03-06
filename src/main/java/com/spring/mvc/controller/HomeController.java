package com.spring.mvc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.spring.mvc.command.common.LoginCommand;
import com.spring.mvc.config.MvcConfiguration;

@Controller
@ComponentScan(basePackages="com.spring.mvc")
public class HomeController {

	//Passed
	@RequestMapping(value = {"/", "/index"})
	public ModelAndView Home(HttpServletResponse response, Model m) throws IOException{
		m.addAttribute("command", new LoginCommand());
		return new ModelAndView("home");
	}

}
