package com.spring.mvc.controller.userrole;


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

import com.spring.mvc.dao.functioncode.FunctionCodeDAO;
import com.spring.mvc.domain.FunctionCodes;
import com.spring.mvc.domain.Role;
import com.spring.mvc.domain.User;
import com.spring.mvc.services.rolefunctioncode.RoleFunctionCodeService;
import com.spring.mvc.services.roles.RoleService;
import com.spring.mvc.services.user.UserService;
import com.spring.mvc.services.userrole.UserRoleService;

@Controller
@ComponentScan(basePackages="com.spring.mvc")
public class UserRoleController {
	
	
	@Autowired
	RoleService rolesrv;
	
	@Autowired
	UserService usrsrv;
	

	//Passed
	@RequestMapping(value="/userroles")
	public ModelAndView Home(HttpServletResponse response,  HttpSession session, Model m) throws IOException{
		
		
		List<Role> rolelist = rolesrv.findAll();
		List<User> userlist = usrsrv.findAll();
		
		m.addAttribute("rolelist", rolelist);
		m.addAttribute("userlist", userlist);
		return new ModelAndView ("userrole/userrole");
	}
	
	
}
