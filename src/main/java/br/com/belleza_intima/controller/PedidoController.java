package br.com.belleza_intima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PedidoController {
	@GetMapping("/pedido") //nome que eu quiser colocar
	public String pedido()
	{
		return "pedido"; //caminho real do arquivo
	}

}	