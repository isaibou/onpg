package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Entity.Message;
import com.example.demo.Repository.MessageRepository;

@Controller
public class PresentationController {
	
	public boolean connected;
	@Autowired
	MessageRepository contactRepository;

	@RequestMapping("/presentation")
	public String presentation(Model model, Authentication auth) {
		if (auth == null) {
			connected = false;
		}
		else {
			connected = true;
		}
		model.addAttribute("connected", connected);
		return"about";
	}
	
	
	
	
}
