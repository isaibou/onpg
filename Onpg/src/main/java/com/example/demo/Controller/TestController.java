package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Commentaires;
import com.example.demo.Entity.Users;
import com.example.demo.Repository.CommentairesRepository;
import com.example.demo.Repository.UsersRepository;

@RestController
@RequestMapping("test/")
public class TestController {
		@Autowired
			UsersRepository usersRepository;
		@Autowired
		CommentairesRepository commentairesRepository;
		
		
			
		@GetMapping("users")
			public List<Users> getUsers() {
				return usersRepository.findAll();
			}
		@PostMapping("add")
		 public String addddUser( Users u) {
			 usersRepository.save(u);
			 return "User addes";
		 }
		@GetMapping("getCom")
		public List<Commentaires> getAll(){
			return commentairesRepository.findAll();
		}
		
		@PostMapping("addCom")
		public String addComment(@RequestBody Commentaires com) {
			commentairesRepository.save(com);
			return"comment adde.";
		}
		}
