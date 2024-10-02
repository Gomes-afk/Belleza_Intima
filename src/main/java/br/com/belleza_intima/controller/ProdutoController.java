package br.com.belleza_intima.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.belleza_intima.entity.ProdutoEntity;
import br.com.belleza_intima.repository.ProdutoRepository;

@Controller
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping("/produto")
	public String produto() 
	{
		return "produto";
	}
	
	
	@PostMapping("/salvar_produto")
	public ModelAndView save (
			ModelMap model,
			@ModelAttribute("produtoEntity") ProdutoEntity produtoEntity,
			RedirectAttributes atributes)  throws Exception
	{
		System.out.println("Nome :" + produtoEntity.getNome());
		System.out.println("Senha :" + produtoEntity.getPreco());
		System.out.println("Telefone :" + produtoEntity.getDescricao());
		System.out.println("Email :" + produtoEntity.getQnt_estoque());
		
	ModelAndView mv = new ModelAndView("redirect:/produto");
	produtoRepository.save(produtoEntity);
	/*atributes.addFlashAttribute("mensagem", docenteService.save(docenteEntity));
	*/
	return mv;
	
	}
}
