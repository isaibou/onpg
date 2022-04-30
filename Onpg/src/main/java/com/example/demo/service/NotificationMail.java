package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Inscription;
import com.example.demo.Entity.Message;
import com.example.demo.Entity.Users;


@Service
public class NotificationMail {

	private JavaMailSender javaMailSender;
	
	
	@Autowired
	public NotificationMail(JavaMailSender javaMailSender) {
		super();
		this.javaMailSender = javaMailSender;
	} 


	public void sendMdp(Users user) throws MailException {
		SimpleMailMessage mail = new SimpleMailMessage();
		System.out.println("jesuis rentré dans mail");
		mail.setTo(user.getEmail());
		mail.setFrom("ordrepharmaciensgabon.sup@gmail.com");
		mail.setSubject("Reset PAssword");
		mail.setText("Bonjour  Mr/Mme " +user.getNom()+"."+user.getPrenom()+" . Votre nouveau mot de passe est : " +user.getMdp());
		

		javaMailSender.send(mail);
	}


	public void sendAccuse(Message message) throws MailException {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(message.getEmail());
		mail.setFrom("ordrepharmaciensgabon.sup@gmail.com");
		mail.setSubject("Accusé de reception");
		mail.setText("Bonjour  Mr/Mme " +message.getNom()+". Nous avons bien recu votre message nous vous contacterons dans moins de 48h");
		System.out.println("je suis rentré da,s java mail");

		javaMailSender.send(mail);
	}
	
	public void sendConfirmationInscriptionOrdre(Inscription inscrip) throws MailException {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(inscrip.getEmailInscrip());
		mail.setFrom("ordrepharmaciensgabon.sup@gmail.com");
		mail.setSubject("Accusé de reception");
		mail.setText("Bonjour  Mr/Mme " +inscrip.getNom()+"."+inscrip.getPrenom()+" Nous avons bien recu votre demande d'inscription à l'ordre, votre candidature "
				+ "sera étudiée dans les 48h .");
		System.out.println("je suis rentré da,s java mail");

		javaMailSender.send(mail);
	}	
	
	public void sendConfirmationInscriptionSite(Users user) throws MailException {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmail());
		mail.setFrom("ordrepharmaciensgabon.sup@gmail.com");
		mail.setSubject("Accusé de reception");
		mail.setText("Bonjour  Mr/Mme " +user.getNom()+"."+user.getPrenom()+" Nous avons bien recu votre demande d'inscription sur le site, votre candidature "
				+ "sera étudiée dans les 48h .");
		System.out.println("je suis rentré da,s java mail");

		javaMailSender.send(mail);
	}
	
}
