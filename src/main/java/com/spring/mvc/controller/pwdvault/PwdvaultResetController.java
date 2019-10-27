package com.spring.mvc.controller.pwdvault;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mvc.command.common.LoginCommand;
import com.spring.mvc.command.pwdvault.ResetServerPasswordCommand;
import com.spring.mvc.services.pam.PamService;
import com.spring.mvc.services.pam.PamServiceImpl;
import com.spring.mvc.services.pwdvault.PwdVaultService;

@Controller
public class PwdvaultResetController {

	@Autowired
	PamServiceImpl pamsrv;
	PwdVaultService pwdvaultsrv;
	
	@RequestMapping(value = "/pamresetserver", method=RequestMethod.POST)
	public ModelAndView dashboard(@ModelAttribute("serverinfocmd") ResetServerPasswordCommand rspc,HttpServletResponse response, HttpSession session, Integer serverId) throws IOException{
		System.out.println("Server Reset Quest Got");
		int serverid = rspc.getServerId();
		String username = rspc.getUsername();
		String password = rspc.getPassword();
		System.out.println("Server Id : " + serverid + " new Username " + username + " new Password" + password);
		pwdvaultsrv.resetPassword(serverid, username, password);
		return new ModelAndView("redirect:/pwdvaultsearch");
	}
	
	
	
}
