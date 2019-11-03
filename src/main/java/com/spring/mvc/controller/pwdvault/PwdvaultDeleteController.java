package com.spring.mvc.controller.pwdvault;

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

import com.spring.mvc.services.pwdvault.PwdVaultService;
import com.spring.mvc.services.user.UserService;
import com.spring.mvc.services.userrole.UserRoleService;


@Controller
@ComponentScan(basePackages="com.spring.mvc")
public class PwdvaultDeleteController {

	@Autowired
	UserRoleService usersrv;
	@Autowired
	PwdVaultService pwdvaultsrv;
	
	
	
	@RequestMapping(value="/pamserversdelete")
	public ModelAndView pamServerDelete(@RequestParam(value = "serverId", required = true) Integer serverId, HttpServletResponse response,  HttpSession session, Model m) throws IOException{
		String accessurl = "pamserversdelete";
		System.out.println("Starting pamServerDelete Controller");
		if(usersrv.validateAccess((List<String>) session.getAttribute("rolefunclist"), accessurl)) {
			System.out.println("User Have Access in pamServerDelete Controller user/"+accessurl);
			if (serverId != null) {						// Then new User
				System.out.println("pamServerDelete controller : Deleting pamserver " + serverId);
				pwdvaultsrv.delete(serverId);
				return new ModelAndView("redirect:/pwdvaultsearch");
			}
			return new ModelAndView("redirect:/error");
		}
		return new ModelAndView("redirect:/error");
	}
	
	
}
