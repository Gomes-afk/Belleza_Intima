package br.com.belleza_intima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/login") //nome que eu quiser colocar
	public String principal()
	{
		return "principal"; //caminho real do arquivo
	
	}


}

