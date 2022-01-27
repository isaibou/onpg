package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class ForumController {

	@RequestMapping("/forum")
	public String forum() {
		return"forum4";
	}
	
	@RequestMapping("/forum2")
	public String forum2() {
		return"forum2";
	}
	
	@RequestMapping("/forum4")
	public String forum4() {
		return"forum4";
	}
	
	@RequestMapping("/author")
	public String author() {
		return"author";
	}
	
	
}
