package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entity.Roles;
import com.example.demo.Entity.Users;
import com.example.demo.Repository.RoleRepository;
import com.example.demo.Repository.UsersRepository;
import com.example.demo.service.NotificationMail;

@Controller
public class UsersController {

	@Autowired
	RoleRepository roleRepository;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	UsersRepository userRepository;
	@Autowired
	RoleRepository rolesRepository;
	@Autowired
	NotificationMail notif;
	
	@RequestMapping("/inscriptionS")
	public String InscreiotionS(Model model) {
		List<Roles> allRoles = roleRepository.findAll();
		model.addAttribute("user", new Users());
		Roles role = roleRepository.getById("ADMIN");
		allRoles.remove(role);
		model.addAttribute("allRoles", allRoles);
		
		return"inscription2";
	}
	
	

	@RequestMapping("/saveUsers")
	public String saveUsers(Model model, Users u, @RequestParam (name="mdp1") String mdp1,
			@RequestParam (name="mdp2") String mdp2) {
		System.out.println("mdp1"+mdp1);
		System.out.println("mdp2"+mdp2);
		if (!mdp1.equals(mdp2)) {
			model.addAttribute("error", "Vérifier la conconrdance des mots de passe ou le choix de la spécialité");
			List<Roles> allRoles = roleRepository.findAll();
			model.addAttribute("user", u);
			Roles role = roleRepository.getById("ADMIN");
			allRoles.remove(role);
			model.addAttribute("allRoles", allRoles);
			
			return"inscription2";
		}
		/*
		 * if(role1.equals("")) { model.addAttribute("error",
		 * "Veuillez choisir votre section"); List<Roles> allRoles =
		 * roleRepository.findAll(); model.addAttribute("user", u); Roles role =
		 * roleRepository.getById("ADMIN"); allRoles.remove(role);
		 * model.addAttribute("allRoles", allRoles);
		 * 
		 * return"inscription2"; }
		 */
		
		String newmdp = encoder.encode(mdp1);
		u.setMdp(newmdp);
		u.setActived(false);
		u.setIsNew(true);
		userRepository.save(u);
		System.out.println("Done");
		return"redirect:/index";
	}
	
	@RequestMapping("/activerUser")
	public String activeUser(Model model, String id) {
		Users user = userRepository.getById(id);
		user.setActived(true);
		user.setIsNew(false);
		userRepository.save(user);
		return"redirect:/admin";
	}
	
	@RequestMapping("/desactiverUser")
	public String desactiveUser(Model model, String id) {
		Users user = userRepository.getById(id);
		user.setActived(false);
		userRepository.save(user);
		return"redirect:/admin";
	}
	
	
	
	@RequestMapping("/addAdmin")
	public String promouvoirAdmin(Model model, String id) {
		Users user = userRepository.getById(id);
		Roles role = rolesRepository.getById("ADMIN");
		user.getRoles().add(role);
		return"redirect:/admin";
	}
	
	@RequestMapping("/removeAdmin")
	public String retirerAdmin(Model model, String id) {
		Users user = userRepository.getById(id);
		Roles role = rolesRepository.getById("ADMIN");
		user.getRoles().remove(role);
		return"redirect:/admin";
	}
	
	
	
	@RequestMapping(value ="/forgotPassword" )
	public String forgotPassword(Authentication authentication , Model model) {
		
		model.addAttribute("user", new Users());
		return "forgotPassword";
	}
	
	@RequestMapping(value ="/changePassword" )
	public String changePassword(String password ,
			@RequestParam(name="confirm") String confirm,@RequestParam(name="password") String pass, Authentication auth
			,Model model) {
		String login = auth.getName(); 
		System.out.println("confirm " + confirm + " password" + pass );
		Users u = userRepository.getOne(login);
		
		if(!confirm.isEmpty()&& !pass.isEmpty()) {
			if (confirm.equals(pass)) {
				u.setMdp(encoder.encode(pass));
			}else { 
				model.addAttribute("user",u);
				model.addAttribute("error", "Password and Confirm Password must be Equal");
				return "profile";	
			}
		}else {
			model.addAttribute("user",u);
			model.addAttribute("error", "Password and Confirm Password must not be Empty");
			return "profile";
		}
		
		userRepository.save(u);
		return "redirect:/profile";
	}
	
	@RequestMapping(value ="/resetPassword" )
	public String resetPassword(@RequestParam(name="email") String email) {
		System.out.println(email);
		Users u = userRepository.getOne(email);
		System.out.println(u.getNom());
	String pass = getRandomStr();
	u.setMdp(pass);
	u.setActived(true);
	System.out.println(u.getMdp());
	try {
		System.out.println("avant mail");
		notif.sendMdp(u);
		System.out.println("ap mail");

	} catch (Exception e) {
System.out.println(e);	}
	u.setMdp(encoder.encode(pass));
		
		userRepository.save(u);
		return "redirect:/login1";
	}
	
	 public static String getRandomStr() 
	    {
	        //choisissez un caractére au hasard à partir de cette chaîne
	        String str = "ABCDEFGHJKLMNPQRSTUVWXYZ"
	                    + "abcdefghijkmnopqrstuvxyz" 
	        		+"123456789"; 
	  
	        StringBuilder s = new StringBuilder(8); 
	  
	        for (int i = 0; i < 8; i++) { 
	            int index = (int)(str.length() * Math.random()); 
	            s.append(str.charAt(index)); 
	        } 
	        return s.toString(); 
	    }
	 
	
	
	
	@RequestMapping("/role")
	public String role() {
		
		Roles role1 = new Roles("A", " SECTION A : Officineaux");
		Roles role2 = new Roles("B", " SECTION B : Laboratoires");
		Roles role3 = new Roles("C", " SECTION C : Grossistes");
		Roles role4 = new Roles("D", " SECTION D : Fonctionnaires");
		
		roleRepository.save(role1);
		roleRepository.save(role2);
		roleRepository.save(role3);
		roleRepository.save(role4);
		
		
		System.out.println(role1);
		return"redirect:/index";
	}
}
