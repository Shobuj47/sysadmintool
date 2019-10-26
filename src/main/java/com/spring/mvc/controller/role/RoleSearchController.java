package com.spring.mvc.controller.role;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mvc.services.userrole.UserRoleService;

@Controller
@ComponentScan(basePackages="com.spring.mvc")
public class RoleSearchController {

	@Autowired
	UserRoleService usersrv;
	
	//Passed
	@RequestMapping(value="/roles")
	public ModelAndView Home(HttpServletResponse response,  HttpSession session) throws IOException{
		return new ModelAndView("role/roles");
	}
}
