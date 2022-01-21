package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MembresController {

	@RequestMapping("/membres")
	public String Acceuil() {
		return"membres";
	}
}
