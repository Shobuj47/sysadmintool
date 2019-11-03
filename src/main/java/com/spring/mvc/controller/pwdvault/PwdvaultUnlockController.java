package com.spring.mvc.controller.pwdvault;

import java.io.IOException;

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

import com.spring.mvc.command.pwdvault.ResetServerPasswordCommand;
import com.spring.mvc.services.pam.PamServiceImpl;
import com.spring.mvc.services.pwdvault.PwdVaultServiceImpl;

@Controller
@ComponentScan(basePackages="com.spring.mvc")
public class PwdvaultUnlockController {
	
	@Autowired
	PamServiceImpl pamsrv;
	@Autowired
	PwdVaultServiceImpl pwdvaultsrv;
	
	
	@RequestMapping(value = "/pamunlockserver", method=RequestMethod.POST)
	public ModelAndView pamunlockserver(@ModelAttribute("serverinfocmd") ResetServerPasswordCommand rspc,HttpServletResponse response, HttpSession session, Integer serverId, Model m) throws IOException{
		System.out.println("Server Reset Quest Got");
		if (rspc.getUsername() == null) {
			System.out.println("Got Null Request! Redirecting to the Dashboard");
			return new ModelAndView("redirect:/dashboard");
		}else {
		int serverid = rspc.getServerId();
		String username = rspc.getUsername();
		System.out.println("Server Id : " + serverid + " new Username " + username);
		String result = pwdvaultsrv.unlockPassword(serverid, username);
		m.addAttribute("pwresetresult", result);
		}
		return new ModelAndView("redirect:/pwdvaultsearch");
	}
	
	

}
