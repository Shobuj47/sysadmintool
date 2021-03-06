package com.spring.mvc.controller.pwdvault;

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
import org.springframework.web.servlet.ModelAndView;

import com.spring.mvc.command.pwdvault.ResetServerPasswordCommand;
import com.spring.mvc.services.pwdvault.PwdVaultService;
import com.spring.mvc.services.userrole.UserRoleService;

@Controller
@ComponentScan(basePackages="com.spring.mvc")
public class PwdvaultSearchController {
	
	@Autowired
	UserRoleService userrolesrv;
	@Autowired
	PwdVaultService pwdvaultsrv;
	
	@RequestMapping(value="/pwdvaultsearch")
	public ModelAndView pwdvaultsearch(HttpServletResponse response,  HttpSession session, Model m, @ModelAttribute("serverinfocmd") ResetServerPasswordCommand rspc) throws IOException{
		String accessurl = "pwdvaultsearch";
		System.out.println("Starting Dashboard Controller");
		if(userrolesrv.validateAccess((List<String>) session.getAttribute("rolefunclist"), accessurl)) {
			System.out.println("User Have Access in User Controller users/" + accessurl );
			m.addAttribute("pamserverlist", pwdvaultsrv.getUserPAMServer((Integer) session.getAttribute("userId")));
			return new ModelAndView("pam/"+accessurl);
		}
		System.out.println("User Dosen't Have Access in Dashboard Controller");
		return new ModelAndView("redirect:/error");
	}
	
	
}
