package com.example.demo.service;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import com.example.demo.Entity.Inscription;
import com.example.demo.Repository.InscriptionRepository;

@Service
public class ServiceDownloadAWS {

	InscriptionRepository inscriptionRepository;
	
	@Value("${aws.s3.bucket}")
	private String s3bucket;
	 @Autowired
	AmazonS3 amazonS3;
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
