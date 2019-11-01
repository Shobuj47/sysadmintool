package com.spring.mvc.controller.user;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mvc.domain.User;
import com.spring.mvc.services.user.UserService;
import com.spring.mvc.services.userrole.UserRoleService;

@Controller
@ComponentScan(basePackages="com.spring.mvc")
public class UserAddModifyController {
	
	@Autowired
	UserRoleService usersrv;
	@Autowired
	UserService usrsrv;
	
	@RequestMapping(value="/userModify", method=RequestMethod.POST)
	public ModelAndView userModify(@ModelAttribute("user") User user, HttpServletResponse response,  HttpSession session, Model m) throws IOException{
		String accessurl = "useraddmodify";
		System.out.println("Starting postUserAddModify Controller");
		if(usersrv.validateAccess((List<String>) session.getAttribute("rolefunclist"), accessurl)) {
			System.out.println("User Have Access in postUserAddModify Controller user/"+accessurl);
			System.out.println("User Have Access in postUserAddModify Controller user " + user.getComponentId());
			if(user.getComponentId() != null){ 			//Then existing user. So update user
				System.out.println("postUserAddModify controller : updating user " + user.getComponentId());
				usrsrv.update(user);
				return new ModelAndView("user/"+accessurl);
			} else {
				System.out.println("postUserAddModify controller : Adding New User  username : " + user.getUsername());
				usrsrv.save(user);
				System.out.println("New User Saved");
				return new ModelAndView("user/"+accessurl);
			}
		}
		System.out.println("User Dosen't Have Access in postUserAddModify Controller");
		return new ModelAndView("redirect:/error");
	}
	
	
	@RequestMapping(value="/useraddmodify")
	public ModelAndView getUserAddModify(@RequestParam(value = "userId", required = false) Integer usrid, HttpServletResponse response,  HttpSession session, Model m) throws IOException{
		String accessurl = "useraddmodify";
		System.out.println("Starting getUserAddModify Controller");
		if(usersrv.validateAccess((List<String>) session.getAttribute("rolefunclist"), accessurl)) {
			System.out.println("User Have Access in getUserAddModify Controller user/"+accessurl);
			User usr = new User();
			if (usrid != null) {		//Existing User. so map the existing user to the form fields
				System.out.println("getUserAddModify controller : Got Existing User Id " + usrid);
				System.out.println("getUserAddModify controller : Adding the user to the model");
				usr = usrsrv.findById(usrid);
			}				
			//Not Existing User. so add blank object to the form
			System.out.println("getUserAddModify controller : No User Id detected adding a blank user object");
			m.addAttribute("user", usr);
			return new ModelAndView("user/"+accessurl);
		}
		System.out.println("User Dosen't Have Access in getUserAddModify Controller");
		return new ModelAndView("redirect:/error");
	}
	
	

	
	
}
