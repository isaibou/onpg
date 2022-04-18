package com.example.demo.Controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entity.Commentaires;
import com.example.demo.Entity.Sujet;
import com.example.demo.Entity.Users;
import com.example.demo.Repository.CommentairesRepository;
import com.example.demo.Repository.SujetRepository;
import com.example.demo.Repository.UsersRepository;
@Controller
public class ForumController {
	
	@Autowired
	SujetRepository sujetRepository;
	@Autowired
	CommentairesRepository commentairesRepository;
	@Autowired
	UsersRepository userRepository;
	
	public  boolean connected;
	
	
	
	@RequestMapping("/forum")
	public String forum(Model model , Authentication auth) {
		
		if (auth == null) {
			connected = false;
		}
		else {
			connected = true;
		}
		model.addAttribute("connected", connected);
		
		
		List<Sujet> sujets  = sujetRepository.findAll();
		System.out.println(sujets);
		model.addAttribute("sujets", sujets);
		return"forum4";
	}
	
	@RequestMapping("/comments")
	public String forum2(Model model, Long id ) {
		Sujet sujet = sujetRepository.getById(id);
		List<Commentaires> comments = commentairesRepository.findBySujets(sujet);
		model.addAttribute("allComments", comments);
		System.out.println(comments);
		model.addAttribute("idSujet", id);
		System.out.println("l id est de : "+id);
		model.addAttribute("sujet", sujet);
		model.addAttribute("com", new Commentaires());

		return"forum5";
	}
	
	
	@RequestMapping("/addComment")
	public String addComment(String comments, Authentication auth, Model model , @RequestParam(name = "idSujet") Long id) {
		Users user = userRepository.getById(auth.getName());
		Sujet sujet = sujetRepository.getById(id);
		Commentaires commentaire = new Commentaires();
		commentaire.setComments(comments);
		commentaire.setDate(new Date());
		commentaire.setSujets(sujet);
		commentaire.setUsers(user);
		commentairesRepository.save(commentaire);
		List<Commentaires> commentaires = commentairesRepository.findBySujets(sujet);
		model.addAttribute("allComments", commentaires);
		System.out.println(comments);
		model.addAttribute("idSujet", id);
		System.out.println("l id est de : "+id);
		model.addAttribute("sujet", sujet);
		model.addAttribute("com", new Commentaires());

		return"forum5";
	}
	
	
	
	@RequestMapping("/forum4")
	public String forum4(Model model) {
		
		return"forum4";
	}
	
	@RequestMapping("/author")
	public String author() {
		return"author";
	}
	
	
	public  Long nbCom(Sujet sujet) {
		List<Commentaires> allComment =  commentairesRepository.findBySujets(sujet);
		Long total = (long) allComment.size();
		return total ;
	}
	
	
	
	
}
