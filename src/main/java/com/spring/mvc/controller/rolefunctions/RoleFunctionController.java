package com.spring.mvc.controller.rolefunctions;

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
import com.spring.mvc.services.rolefunctioncode.RoleFunctionCodeService;
import com.spring.mvc.services.roles.RoleService;


@Controller
@ComponentScan(basePackages="com.spring.mvc")
public class RoleFunctionController {

	

	@Autowired
	RoleService rolesrv;
	
	@Autowired
	RoleFunctionCodeService rfcs;
	
	@Autowired
	FunctionCodeDAO fcdao;
	

	@RequestMapping(value="/rolefunctions")
	public ModelAndView Home(HttpServletResponse response,  HttpSession session, Model m) throws IOException{
		
		
		List<Role> rolelist = rolesrv.findAll();
		List<FunctionCodes> functioncodelist = fcdao.findAll();
		
		m.addAttribute("rolelist", rolelist);
		m.addAttribute("functionlist", functioncodelist);
		return new ModelAndView ("rolefunctions/rolefunctions");
	}
	
	
	
	
	
	
	
}
