package com.spring.mvc.controller.user;

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

import com.spring.mvc.services.userrole.UserRoleService;

@Controller
@ComponentScan(basePackages="com.spring.mvc")
public class UserAddModifyController {
	
	@Autowired
	UserRoleService usersrv;
	
	
	@RequestMapping(value="/useraddmodify", method=RequestMethod.GET)
	public ModelAndView getUserAddModify(HttpServletResponse response,  HttpSession session) throws IOException{
		String accessurl = "useraddmodify";
		System.out.println("Starting getUserAddModify Controller");
		if(usersrv.validateAccess((List<String>) session.getAttribute("rolefunclist"), accessurl)) {
			System.out.println("User Have Access in getUserAddModify Controller user/"+accessurl);
			return new ModelAndView("user/"+accessurl);
		}
		System.out.println("User Dosen't Have Access in getUserAddModify Controller");
		return new ModelAndView("redirect:/error");
	}
	
	@RequestMapping(value="/useraddmodify", method=RequestMethod.POST)
	public ModelAndView postUserAddModify(HttpServletResponse response,  HttpSession session) throws IOException{
		String accessurl = "useraddmodify";
		System.out.println("Starting postUserAddModify Controller");
		if(usersrv.validateAccess((List<String>) session.getAttribute("rolefunclist"), accessurl)) {
			System.out.println("User Have Access in postUserAddModify Controller user/"+accessurl);
			return new ModelAndView("user/"+accessurl);
		}
		System.out.println("User Dosen't Have Access in postUserAddModify Controller");
		return new ModelAndView("redirect:/error");
	}
	
	
	
	
}
