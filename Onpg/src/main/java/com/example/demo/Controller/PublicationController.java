package com.example.demo.Controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Entity.OffreEntity;
import com.example.demo.Entity.PubliScientEntity;
import com.example.demo.Repository.OffreRepository;
import com.example.demo.Repository.PubliScientRepository;

@Controller
public class PublicationController {

	@Autowired
	OffreRepository offreRepository;
	@Autowired
	PubliScientRepository publiScienRepository;
	
	@RequestMapping("/publication")
	public String publication(Model model) {
		
		List<OffreEntity> allOffre = offreRepository.findAll();
		List<PubliScientEntity> allPubli = publiScienRepository.findAll();
		model.addAttribute("allOffre", allOffre);
		model.addAttribute("allPubli", allPubli);
		
		return"publication";
	}
	
	@RequestMapping("/addOF")
	public String addOffer() {
		OffreEntity offer = new OffreEntity("Description de l'offre",(long) 2000000, "ONPG", "2 mois");
		offer.setIdOffre((long) 1);
		PubliScientEntity publi = new PubliScientEntity("Auteur", "Sujet 1", "doc.pdf", new Date());
		publi.setIdPubli((long) 1);
		offreRepository.save(offer);
		publiScienRepository.save(publi);
		return"redirect:/publication";
	}
	
}
