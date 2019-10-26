package com.spring.mvc.controller.common;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.spring.mvc.domain.User;
import com.spring.mvc.services.user.UserService;
import com.spring.mvc.services.userrole.UserRoleService;


@Controller
@ComponentScan(basePackages="com.spring.mvc")
public class DashboardController {

	@Autowired
	UserRoleService usersrv;
	
	
	@RequestMapping(value = "/dashboard", method=RequestMethod.GET)
	public ModelAndView dashboard(HttpServletResponse response, HttpSession session) throws IOException{
		String accessurl = "dashboard";
		System.out.println("Starting Dashboard Controller");
		if(usersrv.validateAccess((List<String>) session.getAttribute("rolefunclist"), accessurl)) {
			System.out.println("User Have Access in Dashboard Controller");
			return new ModelAndView("common/"+accessurl);
		}
		System.out.println("User Dosen't Have Access in Dashboard Controller");
		return new ModelAndView("redirect:/error");

	}
	
}
