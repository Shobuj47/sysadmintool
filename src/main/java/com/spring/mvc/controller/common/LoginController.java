package com.spring.mvc.controller.common;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mvc.command.common.FunctionCodesCommand;
import com.spring.mvc.command.common.LoginCommand;
import com.spring.mvc.dao.functioncode.FunctionCodeDAO;
import com.spring.mvc.dao.role.RoleDAO;
import com.spring.mvc.domain.FunctionCodes;
import com.spring.mvc.domain.Role;
import com.spring.mvc.domain.RoleFunctionCodes;
import com.spring.mvc.domain.User;
import com.spring.mvc.domain.UserRole;
import com.spring.mvc.exception.UserBlockedException;
import com.spring.mvc.services.rolefunctioncode.RoleFunctionCodeService;
import com.spring.mvc.services.user.UserService;
import com.spring.mvc.services.userrole.UserRoleService;

@Controller
@ComponentScan(basePackages="com.spring.mvc")
public class LoginController {

	@Autowired
	UserService usrservice;
	@Autowired
	UserRoleService usrrolesrv;
	@Autowired
	RoleFunctionCodeService rfcs;
	User usr;
    
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@ModelAttribute("command") LoginCommand cmd, Model m, HttpSession session){
		try {
			System.out.println("Before getting User " + cmd.getLoginName() + " " + cmd.getPassword());
			User user = usrservice.Login(cmd.getLoginName(), cmd.getPassword());
			if(user == null) {
				System.out.println("User is null");
				return "home";
			} else {
				System.out.println("User Found! User Id " + user.getComponentId() + " Getting User RoleList");
				List<UserRole> roleidlist = usrrolesrv.getUserRoleIdList(user.getComponentId());
				System.out.println("Getting User FunctionCodeList");
				List<String> rolelist = rfcs.getRoleFunctionCodeList(roleidlist);
				System.out.println("Got FunctionCode List. Adding to session");
				addUserInSession(user, rolelist, session);
				return "common/dashboard";
			}
		} catch (UserBlockedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "home";
		}
	}
	
	
	
	@RequestMapping(value="/logout")
	public ModelAndView logout(HttpServletResponse response) throws IOException{
		return new ModelAndView("common/home");
	}
	
	
    private void addUserInSession(User u, List<String> rolelist, HttpSession session) {
        session.setAttribute("user", u);
        session.setAttribute("userId", u.getComponentId());
        session.setAttribute("permissions", rolelist);
    }
	
}
