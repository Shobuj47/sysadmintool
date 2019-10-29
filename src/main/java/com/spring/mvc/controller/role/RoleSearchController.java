package com.spring.mvc.controller.role;

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

import com.spring.mvc.domain.Role;
import com.spring.mvc.services.roles.RoleService;
import com.spring.mvc.services.user.UserService;
import com.spring.mvc.services.userrole.UserRoleService;

@Controller
@ComponentScan(basePackages="com.spring.mvc")
public class RoleSearchController {

	@Autowired
	UserRoleService userrolesrv;
	@Autowired
	RoleService rolesrv;
	
	//Passed
	@RequestMapping(value="/roles")
	public ModelAndView roles(HttpServletResponse response,  HttpSession session,  Model m) throws IOException{
		String accessurl = "roles";
		System.out.println("Starting roles Controller");
		if(userrolesrv.validateAccess((List<String>) session.getAttribute("rolefunclist"), accessurl)) {
			System.out.println("User Have Access in Roles Controller");
			List<Role> rolels = rolesrv.findAll();
			System.out.println("From Roles Controller toatl list of role " + rolels.size() + " Printing from controllers");
			for (Role r1 : rolels){
				System.out.println(r1.getDisplayname());
			}
			
			
			
			m.addAttribute("roleslist", rolels);
			return new ModelAndView("role/"+accessurl);
		}
		System.out.println("User Dosen't Have Access in Roles Controller");
		return new ModelAndView("redirect:/error");
	}
}
