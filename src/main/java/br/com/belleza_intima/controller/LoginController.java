package br.com.belleza_intima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/login") //nome que eu quiser colocar
	public String login()
	{
		return "login"; //caminho real do arquivo
	
	}

	@GetMapping("/") //nome que eu quiser colocar
	public String home()
	{
		return "produto"; //caminho real do arquivo
	
	}


}

