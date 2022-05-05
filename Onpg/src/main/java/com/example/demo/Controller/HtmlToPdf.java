package com.example.demo.Controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;
import java.time.LocalDateTime;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Paiement;
import com.example.demo.Repository.PaiementRepository;
import com.itextpdf.io.IOException;
import com.itextpdf.io.source.ByteArrayOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

@RestController
public class HtmlToPdf {

	@Autowired
	PaiementRepository paiementRepository;
	
	
	@GetMapping("/genpdf")
	HttpEntity<byte[]> createPdf( Long id) throws IOException {
		/* first, get and initialize an engine */
		Paiement paiement = paiementRepository.getOne(id);
		
		String fileName = "Recu "+""+paiement.getNom()+paiement.getPrenom()+".pdf";
		VelocityEngine ve = new VelocityEngine();
		/* next, get the Template */
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class",
				ClasspathResourceLoader.class.getName());
		ve.init();
		Template t = ve.getTemplate("templates/helloworld.vm");
		/* create a context and add data */
		VelocityContext context = new VelocityContext();
	
		context.put("nom", paiement.getNom());
		context.put("prenom", paiement.getPrenom());
		context.put("montant", paiement.getMontant());
		context.put("moyen", paiement.getModePaiement());
		context.put("motif", paiement.getRaison());
		context.put("date", paiement.getDateDepot().toString());
		context.put("genDateTime", LocalDateTime.now().toString());
		/* now render the template into a StringWriter */
		StringWriter writer = new StringWriter();
		t.merge(context, writer);
		/* show the World */
		System.out.println(writer.toString());
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		baos = generatePdf(writer.toString());
		HttpHeaders header = new HttpHeaders();
	    header.setContentType(MediaType.APPLICATION_PDF);
	    header.set(HttpHeaders.CONTENT_DISPOSITION,
	                   "attachment; filename=" + fileName.replace(" ", "_"));
	    header.setContentLength(baos.toByteArray().length);
	    return new HttpEntity<byte[]>(baos.toByteArray(), header);
	}
	public ByteArrayOutputStream generatePdf(String html) {
		String pdfFilePath = "";
		PdfWriter pdfWriter = null;
		// create a new document
		Document document = new Document();
		try {
			document = new Document();
			// document header attributes
			document.addAuthor("Kinns");
			document.addAuthor("Kinns123");
			document.addCreationDate();
			document.addProducer();
			document.addCreator("kinns123.github.io");
			document.addTitle("HTML to PDF using itext");
			document.setPageSize(PageSize.LETTER);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			PdfWriter.getInstance(document, baos);
			// open document
			document.open();
			XMLWorkerHelper xmlWorkerHelper = XMLWorkerHelper.getInstance();
			xmlWorkerHelper.getDefaultCssResolver(true);
			xmlWorkerHelper.parseXHtml(pdfWriter, document, new StringReader(
					html));
			// close the document
			document.close();
			System.out.println("PDF generated successfully");
			return baos;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@GetMapping("/msg")
	public String printMesssage(){
		return "this is the message";
	}
}
