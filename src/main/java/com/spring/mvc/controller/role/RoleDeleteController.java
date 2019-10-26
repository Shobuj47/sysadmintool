package com.spring.mvc.controller.role;

import java.io.IOException;
import java.util.List;

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
public class RoleDeleteController {

	@Autowired
	UserRoleService usersrv;
	
	
	//Passed
	@RequestMapping(value="/roledelete")
	public ModelAndView Home(HttpServletResponse response,  HttpSession session) throws IOException{
		String accessurl = "dashboard";
		System.out.println("Starting Dashboard Controller");
		if(usersrv.validateAccess((List<String>) session.getAttribute("rolefunclist"), accessurl)) {
			System.out.println("User Have Access in Dashboard Controller");
			return new ModelAndView("role/"+accessurl);
		}
		System.out.println("User Dosen't Have Access in Dashboard Controller");
		return new ModelAndView("redirect:/error");
	}
}
