package com.example.demo.Controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.http.HttpResponse;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import com.example.demo.Entity.Inscription;
import com.example.demo.Entity.OffreEntity;
import com.example.demo.Entity.PubliScientEntity;
import com.example.demo.Entity.TexteReglemantaire;
import com.example.demo.Entity.Users;
import com.example.demo.Repository.OffreRepository;
import com.example.demo.Repository.PubliScientRepository;
import com.example.demo.Repository.TexteReglemantaireRepository;
import com.example.demo.Repository.UsersRepository;
import com.example.demo.service.ServiceDownloadAWS;
import com.example.demo.service.ServiceUploadAWS;

@Controller
public class PublicationController {

	@Autowired
	OffreRepository offreRepository;
	@Autowired
	PubliScientRepository publiScienRepository;
	@Autowired
	UsersRepository userRepository;
	@Autowired
	TexteReglemantaireRepository texteReglementaireRepository;
	
	 @Autowired
		AmazonS3 amazonS3;
		

		@Value("${aws.s3.bucket}")
		private String s3bucket;
	
	public boolean connected;
	
	
	
	@Autowired
	ServiceUploadAWS uploadS3;
	
	@Autowired
	ServiceDownloadAWS downloadS3;
	@RequestMapping("/publication")
	public String publication(Model model, Authentication auth) {
		
		if (auth == null) {
			connected = false;
		}
		else {
			connected = true;
		}
		
		List<OffreEntity> allOffre = offreRepository.findAll();
		List<PubliScientEntity> allPubli = publiScienRepository.findAll();
		List<TexteReglemantaire> allTextes = texteReglementaireRepository.findAll();
		model.addAttribute("allOffre", allOffre);
		model.addAttribute("allPubli", allPubli);
		model.addAttribute("connected", connected);
		model.addAttribute("allTextes", allTextes);

		return"publication";
	}
	
	@RequestMapping(value="/addPublication")
	public String addPublication(Authentication auth , PubliScientEntity publication, @RequestParam("file") MultipartFile file ) {
		Users user = userRepository.getById(auth.getName());
		publication.setUsers(user);
		publication.setDatePubli(new Date());
		uploadS3.uploadPublication(publication, file);
		publiScienRepository.save(publication);
		
		return"redirect:/publication";
	}
	
	@RequestMapping(value="/viewPubli")
	public String domwloadPublication(HttpServletResponse response, Long id ) throws IOException {
		PubliScientEntity publicatio = publiScienRepository.getById(id);
		String fileName = publicatio.getDoc();
		String path = publicatio.getPathDoc();
		downloadS3.viewFile(response, path, fileName);
		
		return"redirect:/publication";
	}
	
	
	@RequestMapping(value="/saveTexte")
	public String uploadTexte(Authentication auth , TexteReglemantaire texte, @RequestParam("file") MultipartFile file ) {
		uploadS3.uploadTexte(texte, file);
		texteReglementaireRepository.save(texte);
		
		return"redirect:/publication";
	}
	
	 @RequestMapping("/viewTexte")
	    public void viewTexte(Long id,HttpServletResponse response) throws IOException {
		 	TexteReglemantaire	 texte = texteReglementaireRepository.getById(id);
		 	 String Path = texte.getPath();
	    	String file = texte.getFileName();
	    	viewFile( response, Path, file);
	    }
	    
	
	
	@RequestMapping(value="/addPubli")
	public String addPubli(Model model) {
		model.addAttribute("publi", new PubliScientEntity());
		return "addPubli";
	}
	
	@RequestMapping(value="/addTexte")
	public String addTexte(Model model) {
		model.addAttribute("texte", new TexteReglemantaire());
		return "addTexte";
	}
	
	
	

    @ResponseBody
	public void viewFile(HttpServletResponse response,String folderPath, String fileName) throws IOException {
		
    	
	  	
	  	 if (fileName.indexOf(".doc")>-1)  response.setContentType("application/msword"); 
	  	 if (fileName.indexOf(".docx")>-1) response.setContentType("application/msword");
	     if (fileName.indexOf(".xls")>-1)  response.setContentType("application/vnd.ms-excel");
	     if (fileName.indexOf(".csv")>-1)  response.setContentType("application/vnd.ms-excel"); 
	     if (fileName.indexOf(".ppt")>-1)  response.setContentType("application/ppt"); 
	     if (fileName.indexOf(".pdf")>-1)  response.setContentType("application/pdf");
	     if (fileName.indexOf(".zip")>-1)  response.setContentType("application/zip");
	  		  
	  		  response.setHeader("Content-Disposition","attachment; filename=" +fileName);
	  		  response.setHeader("Content-Transfer-Encoding", "binary");
  		//response.setHeader("Content-Disposition", "inline;filename=\"" + fileName + "\"");
  		System.out.println(fileName);
  		System.out.println(folderPath);
	 
  		S3Object s3object = amazonS3.getObject(s3bucket, folderPath);
  		S3ObjectInputStream inputStream = s3object.getObjectContent();

		IOUtils.copy(inputStream, response.getOutputStream());

	

}
	 

    @RequestMapping("/viewPublication")
    public void viewPublication(Long id,HttpServletResponse response) throws IOException {
    		PubliScientEntity publication = publiScienRepository.getById(id);
    		String Path =publication.getPathDoc();
    	String file = publication.getDoc();
    	viewFile( response, Path, file);
    }
    
	
	/*
	 * @RequestMapping("/addOF") public String addOffer() { OffreEntity offer = new
	 * OffreEntity("Description de l'offre",(long) 2000000, "ONPG", "2 mois");
	 * offer.setIdOffre((long) 1); PubliScientEntity publi = new
	 * PubliScientEntity("Auteur", "Sujet 1", "doc.pdf", new Date());
	 * publi.setIdPubli((long) 1); offreRepository.save(offer);
	 * publiScienRepository.save(publi); return"redirect:/publication"; }
	 */
}
