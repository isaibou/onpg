package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Entity.Tableau;
import com.example.demo.Repository.TabRepository;

@Controller
public class MembresController {

	@Autowired
	TabRepository tapRepo;
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
		
		
		List<Tableau> tabs = tapRepo.findAll();
		model.addAttribute("tableau", tabs);
		return"membres";
	}
}
