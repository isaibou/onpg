package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Entity.Commentaires;
import com.example.demo.Entity.OffreEntity;
import com.example.demo.Repository.OffreRepository;

@Controller
public class OffreController {

	@Autowired
	OffreRepository offreRepository;
	
	@RequestMapping("/offres")
	public String offres(Model model) {
		List<OffreEntity> offresAll = offreRepository.findAll();
		model.addAttribute("offresAll", offresAll);
		return"offres";
	}
	
	@RequestMapping("/saveOffre")
	public String saveOffre(Model model, OffreEntity offre) {
		offre.setActived(true);
		offreRepository.save(offre);
		return"redirect:/offres";
	}
	
	@RequestMapping("/addOffre")
	public String addOffre(Model model) {
		model.addAttribute("offre", new OffreEntity());
		return"addOffre";
	}
	
	
	
	@RequestMapping("/updateOffre")
	public String updateOffre(Model model, Long id ) {
		OffreEntity offre = offreRepository.getById(id);
		model.addAttribute("offre", offre);
		return"updateOffre";
	}
	
	@RequestMapping("/desactiverOffre")
	public String desactiverOffre(Model model, Long id ) {
		OffreEntity offre = offreRepository.getById(id);
		offre.setActived(false);
		offreRepository.save(offre);
		return"redirect:/offres";
	}
	
	
	
	
	
}
