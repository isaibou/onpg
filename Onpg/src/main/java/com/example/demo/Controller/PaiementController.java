package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class PaiementController {

	@RequestMapping("/paiement")
	public String messagerie(Model model) {
		
		model.addAttribute("ref", "TestIBE");
		model.addAttribute("prix", 100);
		return"paiement";
	}
}
