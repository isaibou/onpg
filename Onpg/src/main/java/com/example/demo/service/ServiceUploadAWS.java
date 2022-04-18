package com.example.demo.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.example.demo.Entity.Inscription;
import com.example.demo.Entity.PubliScientEntity;
import com.example.demo.Entity.TexteReglemantaire;
import com.example.demo.Repository.InscriptionRepository;
import com.example.demo.Repository.PubliScientRepository;
import com.example.demo.Repository.TexteReglemantaireRepository;


@Service
public class ServiceUploadAWS {

	@Autowired
	private AmazonS3 amazonS3;
	
	@Value("${aws.s3.bucket}")
	private String s3bucket;
	@Autowired
	InscriptionRepository inscriptionRepository;
	@Autowired
	PubliScientRepository publicationRepository;
	@Autowired
	TexteReglemantaireRepository texteReglementaireRepository;
	
	public String  uploadAttestationDiplome(Inscription inscription ,MultipartFile multipartFile) {
		String filename = inscription.getIdInscrip()+multipartFile.getOriginalFilename(); // à changer on ajoutant quelque chose entre ID et filename
		File  file = convertMultipartFiletoFile(multipartFile);
		String dossier = "attestationDiplome";
		String path = dossier +"/"+filename;
		inscription.setAttestationDiplome(filename);
		inscription.setPathAttestationDiplome(path);
		inscriptionRepository.save(inscription);
		uploadFile(s3bucket, path, file);
		return "success";
	}
	
	public String  uploadDiplome(Inscription inscription ,MultipartFile multipartFile) {
		File  file = convertMultipartFiletoFile(multipartFile);
		String diplome = "diplome";
		String filename = inscription.getIdInscrip()+multipartFile.getOriginalFilename(); // à changer on ajoutant quelque chose entre ID et filename
		String path = diplome+"/"+filename;
		inscription.setDiplome(filename);
		inscription.setPathDiplome(path);
		inscriptionRepository.save(inscription);
		uploadFile(s3bucket, path, file);
		return "success";
	}
	public String  uploadThese(Inscription inscription ,MultipartFile multipartFile) {
		File  file = convertMultipartFiletoFile(multipartFile);
		String dossier = "these";
		String filename = inscription.getIdInscrip()+multipartFile.getOriginalFilename(); // à changer on ajoutant quelque chose entre ID et filename
		String path = dossier+"/"+filename;
		inscription.setThese(filename);
		inscription.setPathThese(path);
		inscriptionRepository.save(inscription);
		uploadFile(s3bucket, path, file);
		return "success";
	}
	
	public String  uploadCasierJudiciare(Inscription inscription ,MultipartFile multipartFile) {
		File  file = convertMultipartFiletoFile(multipartFile);
		String dossier = "Casier ";
		String filename = inscription.getIdInscrip()+multipartFile.getOriginalFilename(); // à changer on ajoutant quelque chose entre ID et filename
		String path = dossier+"/"+filename;
		inscription.setCasierJudiciaire(filename);
		inscription.setPathCasierJudicaire(path);
		inscriptionRepository.save(inscription);
		uploadFile(s3bucket, path, file);
		return "success";
	}
	
	public String  uploadCV(Inscription inscription ,MultipartFile multipartFile) {
		File  file = convertMultipartFiletoFile(multipartFile);
		String dossier = "CV";
		String filename = inscription.getIdInscrip()+multipartFile.getOriginalFilename(); // à changer on ajoutant quelque chose entre ID et filename
		String path = dossier+"/"+filename;
		inscription.setCV(filename);
		inscription.setPathCV(path);
		inscriptionRepository.save(inscription);
		uploadFile(s3bucket, path, file);
		return "success";
	}
	
	public String  uploadPhotos(Inscription inscription ,MultipartFile multipartFile) {
		File  file = convertMultipartFiletoFile(multipartFile);
		String dossier = "photos";
		String filename = inscription.getIdInscrip()+multipartFile.getOriginalFilename(); // à changer on ajoutant quelque chose entre ID et filename
		String path = dossier+"/"+filename;
		inscription.setPhotos(filename);
		inscription.setPathPhotos(path);
		inscriptionRepository.save(inscription);
		uploadFile(s3bucket, path, file);
		return "success";
	}
	
	public String  uploadPieceIdentitez(Inscription inscription ,MultipartFile multipartFile) {
		File  file = convertMultipartFiletoFile(multipartFile);
		String dossier = "piece_identite";
		String filename = inscription.getIdInscrip()+multipartFile.getOriginalFilename(); // à changer on ajoutant quelque chose entre ID et filename
		String path = dossier+"/"+filename;
		inscription.setPieceIdentite(filename);
		inscription.setPathPieceIdentite(path);
		inscriptionRepository.save(inscription);
		uploadFile(s3bucket, path, file);
		return "success";
	}
	
	public String  uploadCarteSejour(Inscription inscription ,MultipartFile multipartFile) {
		File  file = convertMultipartFiletoFile(multipartFile);
		String dossier = "carteSejour";
		String filename = inscription.getIdInscrip()+multipartFile.getOriginalFilename(); // à changer on ajoutant quelque chose entre ID et filename
		String path = dossier+"/"+filename;
		inscription.setCarteSejour(filename);
		inscription.setPathCarteSejour(path);
		inscriptionRepository.save(inscription);
		uploadFile(s3bucket, path, file);
		return "success";
	}
	
	public String  uploadActeNaissance(Inscription inscription ,MultipartFile multipartFile) {
		File  file = convertMultipartFiletoFile(multipartFile);
		String dossier = "acte_naissance";
		String filename = inscription.getIdInscrip()+multipartFile.getOriginalFilename(); // à changer on ajoutant quelque chose entre ID et filename
		String path = dossier+"/"+filename;
		inscription.setActeNaissance(filename);
		inscription.setPathActeNaissance(path);
		inscriptionRepository.save(inscription);
		uploadFile(s3bucket, path, file);
		return "success";
	}
	
	public String  uploadAttestationRadiation(Inscription inscription ,MultipartFile multipartFile) {
		File  file = convertMultipartFiletoFile(multipartFile);
		String dossier = "attestation_radiation";
		String filename = inscription.getIdInscrip()+multipartFile.getOriginalFilename(); // à changer on ajoutant quelque chose entre ID et filename
		String path = dossier+"/"+filename;
		inscription.setAttestationRadiation(filename);
		inscription.setPathAttestationRadiation(path);
		inscriptionRepository.save(inscription);
		uploadFile(s3bucket, path, file);
		return "success";
	}
	
	public String  uploadAttestationNonExercice(Inscription inscription ,MultipartFile multipartFile) {
		File  file = convertMultipartFiletoFile(multipartFile);
		String dossier = "attestation_non_exercice";
		String filename = inscription.getIdInscrip()+multipartFile.getOriginalFilename(); // à changer on ajoutant quelque chose entre ID et filename
		String path = dossier+"/"+filename;
		inscription.setPathAttestationNonExercice(filename);
		inscription.setPathAttestationNonExercice(path);
		inscriptionRepository.save(inscription);
		uploadFile(s3bucket, path, file);
		return "success";
	}
	
	public String  uploadAttestationEmploie(Inscription inscription ,MultipartFile multipartFile) {
		File  file = convertMultipartFiletoFile(multipartFile);
		String dossier = "attestation_emploie";
		String filename = inscription.getIdInscrip()+multipartFile.getOriginalFilename(); // à changer on ajoutant quelque chose entre ID et filename
		String path = dossier+"/"+filename;
		inscription.setPathAttestationEmploie(filename);
		inscription.setPathAttestationEmploie(path);
		inscriptionRepository.save(inscription);
		uploadFile(s3bucket, path, file);
		return "success";
	}
	
	public String  uploadTraduction(Inscription inscription ,MultipartFile multipartFile) {
		File  file = convertMultipartFiletoFile(multipartFile);
		String dossier = "traduction";
		String filename = inscription.getIdInscrip()+multipartFile.getOriginalFilename(); // à changer on ajoutant quelque chose entre ID et filename
		String path = dossier+"/"+filename;
		inscription.setTraduction(filename);
		inscription.setPathTraduction(path);
		inscriptionRepository.save(inscription);
		uploadFile(s3bucket, path, file);
		return "success";
	}
	
	public String  uploadPublication(PubliScientEntity publication ,MultipartFile multipartFile) {
		File  file = convertMultipartFiletoFile(multipartFile);
		String dossier = "publication";
		String filename = multipartFile.getOriginalFilename(); // à changer on ajoutant quelque chose entre ID et filename
		String path = dossier+"/"+filename;
		publication.setDoc(filename);
		publication.setPathDoc(path);
		publicationRepository.save(publication);
		uploadFile(s3bucket, path, file);
		return "sucess";
	}
	
	public String  uploadTexte(TexteReglemantaire texte ,MultipartFile multipartFile) {
		File  file = convertMultipartFiletoFile(multipartFile);
		String dossier = "texte_reglementaire";
		String filename = multipartFile.getOriginalFilename(); // à changer on ajoutant quelque chose entre ID et filename
		String path = dossier+"/"+filename;
		texte.setFileName(filename);
		texte.setPath(path);
		texteReglementaireRepository.save(texte);
		uploadFile(s3bucket, path, file);
		return "sucess";
	}
	

	private void uploadFile(String bucketName , String filePath, File file) {
		amazonS3.putObject(new PutObjectRequest(bucketName, filePath, file)
				.withCannedAcl(CannedAccessControlList.PublicRead) );
	}
	
	
	public File convertMultipartFiletoFile(MultipartFile multipartFile) {
		File file = new File(multipartFile.getOriginalFilename());
		try {
			FileOutputStream outputStream = new FileOutputStream(file);
			outputStream.write(multipartFile.getBytes());
		}
		catch(final IOException e) {
			System.out.println("Error to convert MultipartFile to File" + e.getMessage());
		}
		
		return file;
	}
}
