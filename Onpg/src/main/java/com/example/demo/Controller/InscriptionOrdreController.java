package com.example.demo.Controller;

import java.io.IOException;

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
import com.example.demo.Entity.Inscription;
import com.example.demo.Repository.InscriptionRepository;
import com.example.demo.service.ServiceDownloadAWS;
import com.example.demo.service.ServiceUploadAWS;

@Controller
public class InscriptionOrdreController {

	@Autowired
	ServiceUploadAWS uploadS3;
	@Autowired
	InscriptionRepository inscriptionRepository;
	@Autowired
	ServiceDownloadAWS downloadS3;
	

	@Value("${aws.s3.bucket}")
	private String s3bucket;
	 @Autowired
	AmazonS3 amazonS3;
	
	 public boolean connected;
	
	@RequestMapping("/inscriptionO")
	public String InscriptionO(Authentication auth, Model model) {
		if (auth == null) {
			connected = false;
		}
		else {
			connected = true;
		}
		model.addAttribute("connected", connected);
		
		return"inscriptionO";
	}
	
	
	
	@RequestMapping("/insO")
	public String InsO(Model model) {
		model.addAttribute("inscrip", new Inscription());
		return"addInsO";
	}
		
		@RequestMapping("/insO2")
		public String InsO2() {
			return"addInsO2";
	}
	@RequestMapping("/add")
	public String add() {
		return"add";
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
		 
		
		private String attestationDiplome;	

	    
	    @RequestMapping("/viewAD")
	    public void viewAD(Long id,HttpServletResponse response) throws IOException {
	    	Inscription inscrip = inscriptionRepository.getById(id);
	    	String PathAD = inscrip.getPathAttestationDiplome();
	    	String AD = inscrip.getAttestationDiplome();
	    	viewFile( response, PathAD, AD);
	    }
	    
		private String diplome;

	    @RequestMapping("/viewDiplome")
	    public void viewDiplome(Long id,HttpServletResponse response) throws IOException {
	    	Inscription inscrip = inscriptionRepository.getById(id);
	    	String Path = inscrip.getPathDiplome();
	    	String file = inscrip.getDiplome();
	    	viewFile( response, Path, file);
	    }
	
		private String these;

	    @RequestMapping("/viewThese")
	    public void viewThese(Long id,HttpServletResponse response) throws IOException {
	    	Inscription inscrip = inscriptionRepository.getById(id);
	    	String Path = inscrip.getPathThese();
	    	String file = inscrip.getThese();
	    	viewFile( response, Path, file);
	    }
	    
		private String casierJudiciaire;

	
	    @RequestMapping("/viewCJ")
	    public void viewCJ(Long id,HttpServletResponse response) throws IOException {
	    	Inscription inscrip = inscriptionRepository.getById(id);
	    	String Path = inscrip.getPathCasierJudicaire();
	    	String file = inscrip.getCasierJudiciaire();
	    	viewFile( response, Path, file);
	    }
	
		private String CV;

	    @RequestMapping("/viewCV")
	    public void viewCV(Long id,HttpServletResponse response) throws IOException {
	    	Inscription inscrip = inscriptionRepository.getById(id);
	    	String Path = inscrip.getPathCV();
	    	String file = inscrip.getCV();
	    	viewFile( response, Path, file);
	    }
	    
		private String photos;
  
	    
	    @RequestMapping("/viewPhotos")
	    public void viewPhotos(Long id,HttpServletResponse response) throws IOException {
	    	Inscription inscrip = inscriptionRepository.getById(id);
	    	String Path = inscrip.getPathPhotos();
	    	String file = inscrip.getPhotos();
	    	viewFile( response, Path, file);
	    }
	
	 
	
	    private String pieceIdentite;
	    
	    @RequestMapping("/viewPI")
	    public void viewPI(Long id,HttpServletResponse response) throws IOException {
	    	Inscription inscrip = inscriptionRepository.getById(id);
	    	String Path = inscrip.getPathPieceIdentite();
	    	String file = inscrip.getPieceIdentite();
	    	viewFile( response, Path, file);
	    }
		private String carteSejour;
		
		 @RequestMapping("/viewCS")
		    public void viewCS(Long id,HttpServletResponse response) throws IOException {
		    	Inscription inscrip = inscriptionRepository.getById(id);
		    	String Path = inscrip.getPathCarteSejour();
		    	String file = inscrip.getCarteSejour();
		    	viewFile( response, Path, file);
		    }
		private String acteNaissance;
		
		 @RequestMapping("/viewAN")
		    public void viewAN(Long id,HttpServletResponse response) throws IOException {
		    	Inscription inscrip = inscriptionRepository.getById(id);
		    	String Path = inscrip.getPathActeNaissance();
		    	String file = inscrip.getActeNaissance();
		    	viewFile( response, Path, file);
		    }
		private String attestationRadiation;
		
		 @RequestMapping("/viewAR")
		    public void viewAR(Long id,HttpServletResponse response) throws IOException {
		    	Inscription inscrip = inscriptionRepository.getById(id);
		    	String Path = inscrip.getPathAttestationRadiation();
		    	String file = inscrip.getAttestationRadiation();
		    	viewFile( response, Path, file);
		    }
		private String attesationNonExercice;
		
		 @RequestMapping("/viewANE")
		    public void viewANE(Long id,HttpServletResponse response) throws IOException {
		    	Inscription inscrip = inscriptionRepository.getById(id);
		    	String Path = inscrip.getPathAttestationNonExercice();
		    	String file = inscrip.getAttesationNonExercice();
		    	viewFile( response, Path, file);
		    }
		private String attesationEmploie;
		
		 @RequestMapping("/viewAE")
		    public void viewAE(Long id,HttpServletResponse response) throws IOException {
		    	Inscription inscrip = inscriptionRepository.getById(id);
		    	String Path = inscrip.getPathAttestationEmploie();
		    	String file = inscrip.getAttesationEmploie();
		    	viewFile( response, Path, file);
		    }
		private String traduction ;
		
		 @RequestMapping("/viewT")
		    public void viewT(Long id,HttpServletResponse response) throws IOException {
		    	Inscription inscrip = inscriptionRepository.getById(id);
		    	String Path = inscrip.getPathTraduction();
		    	String file = inscrip.getTraduction();
		    	viewFile( response, Path, file);
		    }
	@RequestMapping("/addInscrip2")
	public String addInscrip2(Long id,
			Model model
						  ,
						  
						  @RequestParam("diplomeFile") MultipartFile diplome,
						  
						  @RequestParam("AttestationDiplomeFile") MultipartFile attestationDiplome,
						  
						  @RequestParam("theseFile") MultipartFile these,
						  
						  @RequestParam("casierJudicaireFile") MultipartFile casierJudiciare,
						  
						  @RequestParam("CVFile") MultipartFile CV,@RequestParam("PhotosFile")
						  MultipartFile photos,
						  
						  @RequestParam("pieceIdentiteFile") MultipartFile pieceIdentite,
						  
						  @RequestParam("carteSejourFile") MultipartFile carteSejour,
						  
						  @RequestParam("acteNaissanceFile") MultipartFile acteNaissance,
						  
						  @RequestParam("attestattionRadidationFile") MultipartFile
						  attestationRadiation,
						  
						  @RequestParam("attestationNonExerciceFile") MultipartFile
						  attestatyionNonExercice,
						  
						  @RequestParam("attestationEmploieFile") MultipartFile attestationEmploie,
						  
						  @RequestParam("traductionFile") MultipartFile traduction
						 ) {
		
		Inscription inscrip = inscriptionRepository.getById(id);
		
		  uploadS3.uploadDiplome(inscrip, diplome);
		  uploadS3.uploadAttestationDiplome(inscrip, attestationDiplome) ;
		  uploadS3.uploadActeNaissance(inscrip, acteNaissance);
		  uploadS3.uploadAttestationNonExercice(inscrip, attestatyionNonExercice);
		  uploadS3.uploadAttestationRadiation(inscrip, attestationRadiation);
		  uploadS3.uploadCarteSejour(inscrip, carteSejour);
		  uploadS3.uploadCasierJudiciare(inscrip, casierJudiciare);
		  uploadS3.uploadCV(inscrip, CV); uploadS3.uploadPhotos(inscrip, photos);
		  uploadS3.uploadPieceIdentitez(inscrip, pieceIdentite);
		  uploadS3.uploadThese(inscrip, these); uploadS3.uploadTraduction(inscrip, traduction); 
		  uploadS3.uploadAttestationEmploie(inscrip, attestationEmploie);
		  inscriptionRepository.save(inscrip);
		System.out.println("done");
		return"redirect:/index" ;
	}
	
	@RequestMapping("/addInscrip")
	public String addInscrip(Inscription inscrip,Model model) {
		inscriptionRepository.save(inscrip);
		model.addAttribute("inscrip", inscrip);
		return"addInsO2";
	}

}
