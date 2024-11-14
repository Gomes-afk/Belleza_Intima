package br.com.belleza_intima.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class ProdutoController {
	@GetMapping("/produto") //nome que eu quiser colocar
	public String produto(HttpSession session)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String login = auth.getName();
		System.out.println(login);
		
		session.setAttribute("login", login);
		return "produto"; //caminho real do arquivo
	}
}
