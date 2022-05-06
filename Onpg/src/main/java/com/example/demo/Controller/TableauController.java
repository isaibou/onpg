package com.example.demo.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import com.example.demo.Entity.Tableau;
import com.example.demo.Repository.TabRepository;

@Controller
public class TableauController {

	@Autowired
	TabRepository tabRepo;
	
	
	@RequestMapping("/sai")
	public String dataaa() {
		return"addData";
	}
	

	@RequestMapping("/getData")
	public String  loadData( @RequestParam("ExcelFile") MultipartFile ExcelFile) throws IOException {
		
		List<Tableau> tableaux =  new ArrayList<Tableau>();
		
		
			
		
     //   FileInputStream excelFile = new FileInputStream(new File(file_name));
        XSSFWorkbook workbook = new XSSFWorkbook(ExcelFile.getInputStream());

      //  XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
        XSSFSheet worksheet = workbook.getSheetAt(0);

        
        for(int i=1;i<worksheet.getPhysicalNumberOfRows() ;i++) {
            Tableau tab = new Tableau();
                
            XSSFRow row = worksheet.getRow(i);
          
            
            
          //  tab.setNumInscrip(row.getCell(0).getStringCellValue());

			 tab.setNomPrenom(row.getCell(1).getStringCellValue().toString());
			 
			 
			  tab.setStructure(row.getCell(2).getStringCellValue().toString());
			  
			  tab.setLocalite(row.getCell(3).getStringCellValue().toString());
			  
			  tab.setGrade(row.getCell(4).getStringCellValue().toString());
			  
			  tab.setSection(row.getCell(5).getStringCellValue().toString());
			  
			//  tab.setNum(row.getCell(6).getNumericCellValue());
			 
            
            
            
            
          

            tableaux.add(tab);
            tabRepo.saveAll(tableaux);
        }
		return "done";
        
}
	
}
