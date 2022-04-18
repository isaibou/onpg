package com.example.demo.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String Acceuil() {
		return"LoginVrai";
	}
	@RequestMapping("/login1")
	public String login() {
		return"login1";
	}
	
	@RequestMapping("/forgetPassword")
	public String fpw() {
		return"forgetPassword";
	}
	
	 @RequestMapping(value="/logout", method = RequestMethod.GET)
	 public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	     Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	     if (auth != null){    
	         new SecurityContextLogoutHandler().logout(request, response, auth);
	     }
	     return "redirect:/LoginVrai?logout";
	 }
	 
}
