package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InscriptionSiteController {

	@RequestMapping("/inscriptionS")
	public String InscreiotionS() {
		return"insxriptionS";
	}
}
