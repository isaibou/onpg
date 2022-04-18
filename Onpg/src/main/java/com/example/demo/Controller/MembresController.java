package com.example.demo.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MembresController {

	public boolean connected;
	@RequestMapping("/membres")
	public String Acceuil(Model model, Authentication auth) {
		if (auth == null) {
			connected = false;
		}
		else {
			connected = true;
		}
		model.addAttribute("connected", connected);
		
		return"membres";
	}
}
