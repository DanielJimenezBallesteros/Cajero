package com.daniel.cajero.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/inicio")
	public String procInicio() {
		return "inicio";
	}
}


