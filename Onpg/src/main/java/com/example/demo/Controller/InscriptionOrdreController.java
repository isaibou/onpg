package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InscriptionOrdreController {

	@RequestMapping("/inscriptionO")
	public String InscriptionO() {
		return"inscriptionO";
	}
	
	@RequestMapping("/insO")
	public String InsO() {
		return"addInsO";
	}
	@RequestMapping("/add")
	public String add() {
		return"add";
	}
	
}
