package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entity.Roles;
import com.example.demo.Entity.Users;
import com.example.demo.Repository.RoleRepository;
import com.example.demo.Repository.UsersRepository;

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
	public String saveUsers(Model model, Users u, 
			@RequestParam (name="mdp2") String mdp2) {
		String mdp1 = u.getMdp();
		if (mdp1!=mdp2) {
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
		
		String mdp = u.getMdp();
		String newmdp = encoder.encode(mdp);
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
