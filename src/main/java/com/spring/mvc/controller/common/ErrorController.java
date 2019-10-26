package com.spring.mvc.controller.common;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorController {

	@RequestMapping(value = "/error", method=RequestMethod.GET)
	public ModelAndView dashboard(HttpServletResponse response, HttpSession session) throws IOException{
		return new ModelAndView("common/error");

	}
	
	
}
