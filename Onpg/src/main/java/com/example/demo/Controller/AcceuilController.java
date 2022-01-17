package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AcceuilController {

	@RequestMapping("/index")
	public String Acceuil() {
		return"index";
	}
}
