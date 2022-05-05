package com.example.demo.Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.example.demo.Entity.Paiement;
import com.example.demo.Repository.PaiementRepository;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.lowagie.text.DocumentException;

@RestController
public class newController {

	@Autowired
	PaiementRepository paiementRepository;
	
	
	@PostMapping("/addP")
	  Paiement addPaiement(@RequestBody Paiement p) {
	    return paiementRepository.save(p);
	  }
	
	
	private String parseThymeleafTemplate() {
	    ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
	    templateResolver.setSuffix(".html");
	    templateResolver.setTemplateMode(TemplateMode.HTML);

	    TemplateEngine templateEngine = new TemplateEngine();
	    templateEngine.setTemplateResolver(templateResolver);

	    Context context = new Context();
	    context.setVariable("to", "Baeldung");

	    return templateEngine.process("thymeleaf_template", context);
	}
	
	@RequestMapping("/pdf")
	public void generatePdfFromHtml(String html) throws DocumentException, IOException {
		 html = parseThymeleafTemplate();

	    String outputFolder = System.getProperty("user.home") + File.separator + "thymeleaf.pdf";
	    OutputStream outputStream = new FileOutputStream(outputFolder);

	    ITextRenderer renderer = new ITextRenderer();
	    renderer.setDocumentFromString(html);
	    renderer.layout();
	    renderer.createPDF(outputStream);

	    outputStream.close();
	}
	
	
	@RequestMapping()
	public String firstPdf() throws FileNotFoundException {
		
		String path = "C:\\fisrt.pdf";
		String paratext = "Premier parag";
		
	PdfWriter pdfWriter = new PdfWriter(path);
	PdfDocument  pdfDocument = new PdfDocument(pdfWriter);
	pdfDocument.addNewPage();
	Document document = new Document(pdfDocument);
	document.close();
	
		return "";
	}
	
	
	
	
	
}
