package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PublicationController {

	@RequestMapping("/publication")
	public String publication() {
		return"publication";
	}
}
