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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mvc.services.user.UserService;
import com.spring.mvc.services.userrole.UserRoleService;

@Controller
@ComponentScan(basePackages="com.spring.mvc")
public class UserDeleteController {

	@Autowired
	UserRoleService usersrv;
	@Autowired
	UserService usrsrv;
	
	
	//Passed
	@RequestMapping(value="/userdelete")
	public ModelAndView userSave(@RequestParam(value = "userId", required = true) Integer usrid, HttpServletResponse response,  HttpSession session, Model m) throws IOException{
		String accessurl = "userdelete";
		System.out.println("Starting postUserAddModify Controller");
		if(usersrv.validateAccess((List<String>) session.getAttribute("rolefunclist"), accessurl)) {
			System.out.println("User Have Access in postUserAddModify Controller user/"+accessurl);
			if (usrid != null) {						// Then new User
				System.out.println("postUserAddModify controller : updating username " + usrid);
				usrsrv.delete(usrid);
				return new ModelAndView("redirect:/users");
			}
			return new ModelAndView("redirect:/error");
		}
		return new ModelAndView("redirect:/error");
	}
	
	
}
