package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String Acceuil() {
		return"login";
	}
	@RequestMapping("/login1")
	public String login() {
		return"login1";
	}
	
	@RequestMapping("/forgetPassword")
	public String fpw() {
		return"forgetPassword";
	}
}
