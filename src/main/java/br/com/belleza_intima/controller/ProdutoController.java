package br.com.belleza_intima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProdutoController {
	@GetMapping("/produto") //nome que eu quiser colocar
	public String produto()
	{
		return "produto"; //caminho real do arquivo
	}
}
