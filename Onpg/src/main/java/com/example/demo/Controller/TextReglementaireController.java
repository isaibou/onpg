package com.example.demo.Controller;

import java.io.IOException;
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

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import com.example.demo.Entity.PubliScientEntity;
import com.example.demo.Entity.TexteReglemantaire;
import com.example.demo.Repository.TexteReglemantaireRepository;
import com.example.demo.service.ServiceUploadAWS;

@Controller
public class TextReglementaireController {

	@Autowired
	TexteReglemantaireRepository texteReglementaireRepository;
	
	@Autowired
	ServiceUploadAWS uploadS3;
	
	 @Autowired
		AmazonS3 amazonS3;
		

		@Value("${aws.s3.bucket}")
		private String s3bucket;
	
		
		
		@RequestMapping(value="/texteReglementaire")
		public String publiAdmin(Model model) {
			List<TexteReglemantaire> allTexte = texteReglementaireRepository.findAll();
			model.addAttribute("allTexte", allTexte);
			return "tRAdmin";
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
	 

}
