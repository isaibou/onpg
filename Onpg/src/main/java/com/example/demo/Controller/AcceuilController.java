package com.example.demo.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AcceuilController {

	public boolean connected;
	@RequestMapping("/index")
	public String home() {
		return "redirect:/index1";
	}
	
	
	@RequestMapping("/")
	public String home1() {
		return "redirect:/index1";
	}
	
	
	@RequestMapping("/index1")
	public String Acceuil(Authentication auth, Model model ) {
		if (auth == null) {
			connected = false;
		}
		else {
			connected = true;
		}
		model.addAttribute("connected", connected);
		
		return"index";
	}
	
	@RequestMapping("/v")
	public String testpdf() {
		return "testpdf2";
	}
}
