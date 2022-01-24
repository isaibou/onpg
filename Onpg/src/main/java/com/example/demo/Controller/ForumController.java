package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class ForumController {

	@RequestMapping("/forum")
	public String forum() {
		return"forum";
	}
	
	@RequestMapping("/forum2")
	public String forum2() {
		return"forum2";
	}
	
	@RequestMapping("/author")
	public String author() {
		return"author";
	}
	
	
}
