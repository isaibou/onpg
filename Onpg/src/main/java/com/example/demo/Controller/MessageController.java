package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Entity.Message;
import com.example.demo.Repository.MessageRepository;
import com.example.demo.service.NotificationMail;

@Controller
public class MessageController {
	@Autowired
	MessageRepository messageRepository;
	@Autowired
	NotificationMail notif;
	
	@RequestMapping("/saveMessage")
	public String saveContact(Message message) {
		message.setDone(false);
	//	notif.sendAccuse(message);
		messageRepository.save(message);
		return "redirect:/presentation";
	}
	
	@RequestMapping("/workMessage")
	public String workMessage(Long id) {
		Message message = messageRepository.getById(id);
		message.setDone(true);
		messageRepository.save(message);
		return "redirect:/message";
	}
	
	@RequestMapping("/message")
	public String doneContact(Model model) {
		List<Message> newsMessages = messageRepository.findByIsDone(false);
		model.addAttribute("newsMessages", newsMessages);
		return"message";
	}
	
}
