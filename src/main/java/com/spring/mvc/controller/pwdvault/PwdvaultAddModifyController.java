package com.spring.mvc.controller.pwdvault;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mvc.domain.Pwdvault;
import com.spring.mvc.domain.User;
import com.spring.mvc.services.pwdvault.PwdVaultService;
import com.spring.mvc.services.userrole.UserRoleService;

@Controller
public class PwdvaultAddModifyController {
	
	
	@Autowired
	UserRoleService usersrv;
	@Autowired
	PwdVaultService pwdvaultsrv;
	
	@RequestMapping(value="/pamserversaddmodify")
	public ModelAndView getPamServerAddModify(@RequestParam(value = "serverId", required = false) Integer serverId, HttpServletResponse response,  HttpSession session, Model m) throws IOException{
		String accessurl = "pamserversaddmodify";
		System.out.println("Starting getPamServerAddModify Controller");
		if(usersrv.validateAccess((List<String>) session.getAttribute("rolefunclist"), accessurl)) {
			System.out.println("User Have Access in getPamServerAddModify Controller user/"+accessurl);
			Pwdvault pwdserver = new Pwdvault();;
			if (serverId != null) {		//Existing User. so map the existing user to the form fields
				System.out.println("getPamServerAddModify controller : Got Existing Server Id " + serverId);
				System.out.println("getPamServerAddModify controller : Adding the Server to the model");
				pwdserver = pwdvaultsrv.findById(serverId);
			}				
			//Not Existing User. so add blank object to the form
			System.out.println("getPamServerAddModify controller : No Server Id detected adding a blank Server object");
			m.addAttribute("pwdserver", pwdserver);
			return new ModelAndView("pam/"+accessurl);
		}
		System.out.println("User Dosen't Have Access in getPamServerAddModify Controller");
		return new ModelAndView("redirect:/error");
	}
	
	
	@RequestMapping(value="/pamserversaddmodify", method=RequestMethod.POST)
	public ModelAndView postPamServerAddModify(@ModelAttribute("pamserver") Pwdvault pwdvault, HttpServletResponse response,  HttpSession session, Model m) throws IOException{
		String accessurl = "pamserversaddmodify";
		System.out.println("Starting postPamServerAddModify Controller");
		if(usersrv.validateAccess((List<String>) session.getAttribute("rolefunclist"), accessurl)) {
			System.out.println("User Have Access in postPamServerAddModify Controller Server/"+accessurl);
			System.out.println("User Have Access in postPamServerAddModify Controller Server " + pwdvault.getComponentId());
			if(pwdvault.getComponentId() != null){ 			//Then existing user. So update user
				System.out.println("postPamServerAddModify controller : updating Server " + pwdvault.getComponentId());
				pwdvaultsrv.update(pwdvault);
				return new ModelAndView("redirect:/pwdvaultsearch");
			} else {
				System.out.println("postPamServerAddModify controller : Adding New Server  servername : " + pwdvault.getDisplayname());
				pwdvaultsrv.save(pwdvault);
				System.out.println("New Server Saved");
				return new ModelAndView("redirect:/pwdvaultsearch");
			}
		}
		System.out.println("User Dosen't Have Access in postUserAddModify Controller");
		return new ModelAndView("redirect:/error");
	}
	
	
}
