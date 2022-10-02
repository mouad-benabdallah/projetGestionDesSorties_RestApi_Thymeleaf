package com.exo.web.th;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
	@GetMapping("")
	public String index() {
		return "index";
	}
	@GetMapping("projetfinal")
	public String welcom() {
		return "welcome";
	}

}
