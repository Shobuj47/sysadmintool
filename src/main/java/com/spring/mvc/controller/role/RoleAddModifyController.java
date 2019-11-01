package com.spring.mvc.controller.role;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mvc.domain.Role;
import com.spring.mvc.domain.User;
import com.spring.mvc.services.roles.RoleService;
import com.spring.mvc.services.userrole.UserRoleService;
import com.spring.mvc.services.userrole.UserRoleServiceImpl;

@Controller
@ComponentScan(basePackages="com.spring.mvc")
public class RoleAddModifyController {

	@Autowired
	UserRoleService usersrv;
	@Autowired
	RoleService rolesrv;
	
	//Passed
	@RequestMapping(value="/rolesaddmodify")
	public ModelAndView getRolesAddModify(@RequestParam(value = "roleId", required = false) Integer roleId,HttpServletResponse response,  HttpSession session, Model m) throws IOException{
		String accessurl = "rolesaddmodify";
		System.out.println("Starting getRolesAddModify Controller");
		if(usersrv.validateAccess((List<String>) session.getAttribute("rolefunclist"), accessurl)) {
			System.out.println("User Have Access in "+accessurl+" Controller");
			Role role = new Role();
			if(roleId != null) {
				System.out.println("getRolesAddModify : roleId "+ role.getComponentId());
				role = rolesrv.findById(roleId);
				System.out.println(" getRolesAddModify : roleName " + role.getDisplayname());
			}
			m.addAttribute("role", role);
			return new ModelAndView("role/"+accessurl);
		}
		System.out.println("User Dosen't Have Access in Dashboard Controller");
		return new ModelAndView("redirect:/error");
		
	}
	
	
	@RequestMapping(value="/rolesaddmodify", method=RequestMethod.POST)
	public ModelAndView postRolesAddModify(@ModelAttribute("role") Role role,HttpServletResponse response,  HttpSession session, Model m) throws IOException{
		String accessurl = "rolesaddmodify";
		System.out.println("Starting getRolesAddModify Controller");
		if(usersrv.validateAccess((List<String>) session.getAttribute("rolefunclist"), accessurl)) {
			System.out.println("User Have Access in "+accessurl+" Controller");
			if (role.getComponentId() !=  null) {		//Existing Role
				System.out.println("Existing Role Detected! roleId " + role.getComponentId());
				rolesrv.update(role);
			}else {										// New Role
				System.out.println("No roleId Detected Adding New Role");
				rolesrv.save(role);
			}
			
			return new ModelAndView("role/"+accessurl);
		}
		System.out.println("User Dosen't Have Access in Dashboard Controller");
		return new ModelAndView("redirect:/error");
	}
	
	
	
	
}
