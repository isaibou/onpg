package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PresentationController {

	@RequestMapping("/presentation")
	public String presentation() {
		return"about";
	}
}
