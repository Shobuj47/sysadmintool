package com.spring.mvc.controller.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.spring.mvc.services.user.UserService;
import com.spring.mvc.services.userrole.UserRoleService;

@Controller
@ComponentScan(basePackages="com.spring.mvc")
public class UserSearchController {
	

	@Autowired
	UserRoleService userrolesrv;
	@Autowired
	UserService usersrv;
	
	
	//Passed
	@RequestMapping(value="/users")
	public ModelAndView Home(HttpServletResponse response,  HttpSession session, Model m) throws IOException{
		String accessurl = "users";
		System.out.println("Starting Dashboard Controller");
		if(userrolesrv.validateAccess((List<String>) session.getAttribute("rolefunclist"), accessurl)) {
			System.out.println("User Have Access in User Controller users/" + accessurl );
			m.addAttribute("userlist", usersrv.findAll());
			return new ModelAndView("user/"+accessurl);
		}
		System.out.println("User Dosen't Have Access in Dashboard Controller");
		return new ModelAndView("redirect:/error");
	}
	
}
