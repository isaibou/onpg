package com.example.demo.Controller;

import java.util.List;import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Entity.Commentaires;
import com.example.demo.Entity.Inscription;
import com.example.demo.Entity.OffreEntity;
import com.example.demo.Entity.Roles;
import com.example.demo.Entity.Users;
import com.example.demo.Repository.CommentairesRepository;
import com.example.demo.Repository.InscriptionRepository;
import com.example.demo.Repository.OffreRepository;
import com.example.demo.Repository.PaiementRepository;
import com.example.demo.Repository.RoleRepository;
import com.example.demo.Repository.UsersRepository;

@Controller
public class AdminController {

	@Autowired
	UsersRepository userRepository;
	@Autowired
	CommentairesRepository commentaireRepository;
	@Autowired
	OffreRepository offreRepository;
	@Autowired
	PaiementRepository paiementRepository;
	@Autowired
	InscriptionRepository inscriptionRepository;
	@Autowired
	RoleRepository rolesRepository;
	
	
	@RequestMapping("/admin")
	public String admin(Model model) {
		List<Users> usersAll = userRepository.findAll();
		model.addAttribute("usersAll", usersAll);
		return"admin1";
	}
	
	

	@RequestMapping("/usersAll")
	public String usersAll(Model model) {
		List<Users> usersAll = userRepository.findAll();
		model.addAttribute("usersAll", usersAll);
		return"usersAll";
	}
	


	
	@RequestMapping("/addCom")
	public String addComments(Model model, Commentaires com) {
		model.addAttribute("com", new Commentaires() );
		return"addCom";
	}
	
	
	@RequestMapping("/saveCom")
	public String saveComments(Commentaires com) {
		commentaireRepository.save(com);
		return"addCom";
	}
	
	@RequestMapping("/actualite")
	public String actualite(Model model, Commentaires com) {
		List<Users> usersAll = userRepository.findAll();
		model.addAttribute("usersAll", usersAll);
		return"actualite";
	}
	
	
	
	@RequestMapping("/inscriptionOrdre")
	public String inscriptionOrdre(Model model, Commentaires com) {
		List<Inscription> inscriptionAll = inscriptionRepository.findAll();
		model.addAttribute("inscriptionAll", inscriptionAll);
		return"inscriptionOrdre";
	}
	
	@RequestMapping("/inscriptionSite")
	public String inscriptionSite(Model model, Commentaires com) {
		List<Users> usersNew = userRepository.findByIsNew(true);
		model.addAttribute("usersNew", usersNew);
		return"inscriptionSite";
	}
	
	
	
	@RequestMapping("/paiementAdmin")
	public String paiementAdmin(Model model, Commentaires com) {
		List<Users> usersAll = userRepository.findAll();
		model.addAttribute("usersAll", usersAll);
		return"paiementAdmin";
	}
	
}
