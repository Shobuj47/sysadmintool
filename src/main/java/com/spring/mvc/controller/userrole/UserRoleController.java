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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	UserRoleService urs;
	
	@Autowired
	UserService usrsrv;
	
//	@RequestMapping(value="/userroles")
//	public ModelAndView getUserRoleService(HttpServletResponse response,  HttpSession session, Model m) throws IOException{
//		String accessurl = "userroles";
//		System.out.println("Starting getUserRoleService Controller");
//		if(urs.validateAccess((List<String>) session.getAttribute("rolefunclist"), accessurl)) {
//			List<User> userlist = usrsrv.findAll();
//			m.addAttribute("userlist", userlist);
//			return new ModelAndView ("userrole/"+ accessurl);
//		}
//		return new ModelAndView("redirect:/error");
//	}
	
	@RequestMapping(value="/userroles")
	public ModelAndView postUserRoles(@RequestParam(value = "usrId", required = false) Integer usrId, HttpServletResponse response,  HttpSession session, Model m) throws IOException{
		String accessurl = "userroles";
		System.out.println("Starting postUserRoles Controller");
		if(urs.validateAccess((List<String>) session.getAttribute("rolefunclist"), accessurl)) {
			if(usrId == null) {
				usrId = (Integer) session.getAttribute("userId");
			}
			System.out.println("Getting Role List");
			List<Role> rolelist = rolesrv.findAll();
			System.out.println("Getting Role List by specified id " + usrId);
			List<Role> userrolelist = urs.getUserRoles(usrId);
			System.out.println("Getting all User List");
			List<User> userlist = usrsrv.findAll();
			
			m.addAttribute("rolelist", rolelist);
			m.addAttribute("userlist", userlist);
			m.addAttribute("userrolelist", userrolelist);
			m.addAttribute("defaultusr", usrId);
			System.out.println("Returning View " + accessurl);
			return new ModelAndView ("userrole/" + accessurl);
		}
		return new ModelAndView("redirect:/error");
	}
	
	
	
	@RequestMapping(value="/saveuserroles")
	public ModelAndView saveUserRoleService(HttpServletResponse response,  HttpSession session, Model m) throws IOException{
		String accessurl = "saveuserroles";
		System.out.println("Starting saveUserRoleService Controller");
		if(urs.validateAccess((List<String>) session.getAttribute("rolefunclist"), accessurl)) {
			List<User> userlist = usrsrv.findAll();
			m.addAttribute("userlist", userlist);
			return new ModelAndView ("userrole/userrole");
		}
		return new ModelAndView("redirect:/" + accessurl);
	}
	
}
