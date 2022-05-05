package com.example.demo.Controller;



import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Entity.Commentaires;
import com.example.demo.Entity.Paiement;
import com.example.demo.Entity.Sujet;
import com.example.demo.Entity.Users;
import com.example.demo.Entity.refAM;
import com.example.demo.Repository.PaiementRepository;
import com.example.demo.Repository.RefAMRepository;

//import com.google.gson.JsonObject;
@Controller
public class PaiementController {
	
	@Autowired
	RefAMRepository regAmrepo;
	@Autowired
	PaiementRepository paiementRpo;

	@RequestMapping("/paiement")
	public String messagerie(Model model) {
		
		refAM ref2 = new refAM();
		regAmrepo.save(ref2);
		
		  String tel_marchand ="076520785" ; 
		  String Montant = "200"; // mettre le prix en string avec le tostring String
		
	     String  ref ="refONPG"+ref2.getIdRef();  ; // référence de la transaction
		  String tel_client = "074213803"; // //com.getClient().getPhoneClient() ;
		  String action ="1"; // 1 par défaut String service = "REST" ; //Web² par défaut
		  String operateur ="AM" ; // doit correspondre au tel marchand 
		  String token ="";
		  // String redirect // l"url de redirection
		  
		  model.addAttribute("tel_marchand", tel_marchand);
		  model.addAttribute("Montant", Montant);
		  model.addAttribute("ref", ref);
		  model.addAttribute("tel_client", tel_client);
		  model.addAttribute("action", action);
		  model.addAttribute("operateur", operateur);
		  model.addAttribute("token", token);
		 model.addAttribute("paiement", new Paiement());
		return"paiement";
	}
	
	
	public void  sendConfirmation(String sms, String phone) throws IOException {

		
		
		/*
		 * //JsonObject Json = new JsonObject(); Json.addProperty("apiKey",
		 * "6639221de968d08cf45fe3db1d425f8b5b0e7640"); Json.addProperty("phoneNumbers",
		 * phone); Json.addProperty("sender", "PH NIBIGH"); Json.addProperty("gamme",
		 * 1); Json.addProperty("message", sms);
		 * 
		 * 
		 * URL url = new URL ("http://api.smspartner.fr/v1/send"); HttpURLConnection con
		 * = (HttpURLConnection)url.openConnection(); con.setRequestMethod("POST");
		 * con.setRequestProperty("Content-Type", "application/json; utf-8");
		 * con.setRequestProperty("Accept", "application/json"); con.setDoOutput(true);
		 * // String jsonInputString=
		 * "{"apiKey":"6639221de968d08cf45fe3db1d425f8b5b0e7640","phoneNumbers": "
		 * +24166368913","sender":"PH NIBIGH","gamme": 1,"message": "Maryam message
		 * test"}'; try(OutputStream os = con.getOutputStream()) { // byte[] input =
		 * jsonInputString.getBytes("utf-8"); byte[] input =
		 * Json.toString().getBytes("utf-8"); os.write(input, 0, input.length); }
		 * 
		 * 
		 * try(BufferedReader br = new BufferedReader( new
		 * InputStreamReader(con.getInputStream(), "utf-8"))) { StringBuilder response =
		 * new StringBuilder(); String responseLine = null; while ((responseLine =
		 * br.readLine()) != null) { response.append(responseLine.trim()); }
		 * System.out.println(response.toString()); }
		 */
  		
		
	}
	
	@RequestMapping(value="/pvit")
	public String pa(Model model) {

		  String tel_marchand ="076520785" ; 
		  String Montant = "200"; // mettre le prix en string avec le tostring String
	     String  ref ="P001"; // référence de la transaction
		  String tel_client = "074213803"; // //com.getClient().getPhoneClient() ;
		  String action ="1"; // 1 par défaut String service = "REST" ; //Web² par défaut
		  String operateur ="AM" ; // doit correspondre au tel marchand 
		  String token ="";
		  // String redirect // l"url de redirection
		  
		  model.addAttribute("tel_marchand", tel_marchand);
		  model.addAttribute("Montant", Montant);
		  model.addAttribute("ref", ref);
		  model.addAttribute("tel_client", tel_client);
		  model.addAttribute("action", action);
		  model.addAttribute("operateur", operateur);
		  model.addAttribute("token", token);
		
		
		
		return"pvit";
	}
	
	
	@RequestMapping("/paiementAdmin")
	public String paiementAdmin(Model model, Commentaires com) {
		List<Paiement> paiement = paiementRpo.findAll();
		model.addAttribute("paiementAll", paiement);
		return"paiementAdmin";
	}

	@RequestMapping("/savePaiement")
	public String saveSujet(Paiement p) {
		p.setDateDepot(new Date());
		paiementRpo.save(p);
		return "redirect:/paiementAdmin";
	}
	
	@RequestMapping("/addCotisation")
	public String addCotisation(Model model) {
		model.addAttribute("cotisation", new Paiement());
		return "addCotisation";
	}
	
	@RequestMapping("/savePaiementAM")
	public String savePaiementAM(Paiement p, Model model) {
		p.setDateDepot(new Date());
		p.setModePaiement("AM");
		paiementRpo.save(p);
		Long prix = p.getMontant();
		refAM ref2 = new refAM();
		regAmrepo.save(ref2);
		
		  String tel_marchand ="076520785" ; 
		  String Montant = "200"; // mettre le prix en string avec le tostring String
		
	     String  ref ="refONPG"+ref2.getIdRef(); 
	     model.addAttribute("ref", ref);
		model.addAttribute("prix", prix);
		return "pvit";
	}
	
	
	
	
}
