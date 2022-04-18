package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Entity.Contact;
import com.example.demo.Repository.ContactRepository;

@Controller
public class PresentationController {
	
	public boolean connected;
	@Autowired
	ContactRepository contactRepository;

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
	
	
	@RequestMapping("/saveContact")
	public String saveContact(Contact contact) {
		contact.setDone(false);
		contactRepository.save(contact);
		return "redirect:/presentation";
	}
	
	@RequestMapping("/workContact")
	public String workContact(Long id) {
		Contact contact = contactRepository.getById(id);
		contact.setDone(true);
		contactRepository.save(contact);
		return "redirect:/presentation";
	}
	
	@RequestMapping("/Contact")
	public String doneContact(Model model) {
		List<Contact> newsContact = contactRepository.findByIsDone(false);
		model.addAttribute("newsContact", newsContact);
		return"actualite";
	}
	
	
}
