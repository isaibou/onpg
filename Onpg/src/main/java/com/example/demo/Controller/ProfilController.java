package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Entity.Users;
import com.example.demo.Repository.UsersRepository;

@Controller
public class ProfilController {
	@Autowired
	UsersRepository userRepository;
	
	@RequestMapping("/profile")
	public String  profile(Model model, Authentication auth) {
		String login = auth.getName();
		Users user = userRepository.getOne(login);
		model.addAttribute("user", user);
		return "profile2";
	}
}
