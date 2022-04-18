package com.example.demo.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Inscription {

	@Id
	@GeneratedValue
	private Long idInscrip;
	private String nom;
	private String prenom;
	private String nationalite;
	private String adresse;

	@DateTimeFormat(pattern= "yyyy-mm-dd")
	private Date dateInscrip;
	private String Lieu;
	private Integer nbAnnee;
	private String commentaires;
	
	private String pathAttestationDiplome;
	private String attestationDiplome;
	
	private String diplome;
	private String pathDiplome;
	
	private String pathThese;
	private String these;
	
	private String pathCasierJudicaire;
	private String casierJudiciaire;
	
	private String pathCV;
	private String CV;
	
	private String photos;
	private String pathPhotos;
	
	private String pieceIdentite;
	private String pathPieceIdentite;
	
	private String carteSejour;
	private String pathCarteSejour;
	
	private String acteNaissance;
	private String pathActeNaissance;
	
	private String attestationRadiation;
	private String pathAttestationRadiation;
	
	private String attesationNonExercice;
	private String pathAttestationNonExercice;
	
	private String attesationEmploie;
	private String pathAttestationEmploie;
	
	private String traduction ;
	private String pathTraduction;
	
	public String getAttestationDiplome() {
		return attestationDiplome;
	}
	public void setAttestationDiplome(String attestationDiplome) {
		this.attestationDiplome = attestationDiplome;
	}
	public String getDiplome() {
		return diplome;
	}
	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}
	public String getPathDiplome() {
		return pathDiplome;
	}
	public void setPathDiplome(String pathDiplome) {
		this.pathDiplome = pathDiplome;
	}
	public String getThese() {
		return these;
	}
	public void setThese(String these) {
		this.these = these;
	}
	public String getCasierJudiciaire() {
		return casierJudiciaire;
	}
	public void setCasierJudiciaire(String casierJudiciaire) {
		this.casierJudiciaire = casierJudiciaire;
	}
	public String getCV() {
		return CV;
	}
	public void setCV(String cV) {
		CV = cV;
	}
	public String getPhotos() {
		return photos;
	}
	public void setPhotos(String photos) {
		this.photos = photos;
	}
	
	
	public String getCarteSejour() {
		return carteSejour;
	}
	public void setCarteSejour(String carteSejour) {
		this.carteSejour = carteSejour;
	}
	public String getActeNaissance() {
		return acteNaissance;
	}
	public void setActeNaissance(String acteNaissance) {
		this.acteNaissance = acteNaissance;
	}
	public String getAttestationRadiation() {
		return attestationRadiation;
	}
	public void setAttestationRadiation(String attestationRadiation) {
		this.attestationRadiation = attestationRadiation;
	}
	public String getAttesationNonExercice() {
		return attesationNonExercice;
	}
	public void setAttesationNonExercice(String attesationNonExercice) {
		this.attesationNonExercice = attesationNonExercice;
	}
	public String getAttesationEmploie() {
		return attesationEmploie;
	}
	public void setAttesationEmploie(String attesationEmploie) {
		this.attesationEmploie = attesationEmploie;
	}
	public String getTraduction() {
		return traduction;
	}
	public void setTraduction(String traduction) {
		this.traduction = traduction;
	}
	
	public Inscription() {
		super();
	}
	public Long getIdInscrip() {
		return idInscrip;
	}
	public void setIdInscrip(Long idInscrip) {
		this.idInscrip = idInscrip;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getNationalite() {
		return nationalite;
	}
	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public Date getDateInscrip() {
		return dateInscrip;
	}
	public void setDateInscrip(Date dateInscrip) {
		this.dateInscrip = dateInscrip;
	}
	public String getLieu() {
		return Lieu;
	}
	public void setLieu(String lieu) {
		Lieu = lieu;
	}
	public Integer getNbAnnee() {
		return nbAnnee;
	}
	public void setNbAnnee(Integer nbAnnee) {
		this.nbAnnee = nbAnnee;
	}
	public String getCommentaires() {
		return commentaires;
	}
	public void setCommentaires(String commentaires) {
		this.commentaires = commentaires;
	}
	public String getPathAttestationDiplome() {
		return pathAttestationDiplome;
	}
	public void setPathAttestationDiplome(String pathAttestationDiplome) {
		this.pathAttestationDiplome = pathAttestationDiplome;
	}
	public String getPathThese() {
		return pathThese;
	}
	public void setPathThese(String pathThese) {
		this.pathThese = pathThese;
	}
	public String getPathCasierJudicaire() {
		return pathCasierJudicaire;
	}
	public void setPathCasierJudicaire(String pathCasierJudicaire) {
		this.pathCasierJudicaire = pathCasierJudicaire;
	}
	public String getPathCV() {
		return pathCV;
	}
	public void setPathCV(String pathCV) {
		this.pathCV = pathCV;
	}
	public String getPathPhotos() {
		return pathPhotos;
	}
	public void setPathPhotos(String pathPhotos) {
		this.pathPhotos = pathPhotos;
	}
	
	public void setPieceIdentite(String pieceIdentite) {
		this.pieceIdentite = pieceIdentite;
	}
	public String getPieceIdentite() {
		return pieceIdentite;
	}
	public String getPathPieceIdentite() {
		return pathPieceIdentite;
	}
	public void setPathPieceIdentite(String pathPieceIdentite) {
		this.pathPieceIdentite = pathPieceIdentite;
	}
	public String getPathCarteSejour() {
		return pathCarteSejour;
	}
	public void setPathCarteSejour(String pathCarteSejour) {
		this.pathCarteSejour = pathCarteSejour;
	}
	public String getPathActeNaissance() {
		return pathActeNaissance;
	}
	public void setPathActeNaissance(String pathActeNaissance) {
		this.pathActeNaissance = pathActeNaissance;
	}
	public String getPathAttestationRadiation() {
		return pathAttestationRadiation;
	}
	public void setPathAttestationRadiation(String pathAttestationRadiation) {
		this.pathAttestationRadiation = pathAttestationRadiation;
	}
	public String getPathAttestationNonExercice() {
		return pathAttestationNonExercice;
	}
	public void setPathAttestationNonExercice(String pathAttestationNonExercice) {
		this.pathAttestationNonExercice = pathAttestationNonExercice;
	}
	public String getPathAttestationEmploie() {
		return pathAttestationEmploie;
	}
	public void setPathAttestationEmploie(String pathAttestationEmploie) {
		this.pathAttestationEmploie = pathAttestationEmploie;
	}
	public String getPathTraduction() {
		return pathTraduction;
	}
	public void setPathTraduction(String pathTraduction) {
		this.pathTraduction = pathTraduction;
	}
	
	
	
}
