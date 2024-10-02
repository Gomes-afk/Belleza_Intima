package br.com.belleza_intima.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.ui.ModelMapExtensionsKt;

import br.com.belleza_intima.entity.UsuarioEntity;
import br.com.belleza_intima.repository.UsuarioRepository;
import ch.qos.logback.core.model.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("/loja")
	public String usuario() 
	{
		return "loja";
	}
	
	
	@PostMapping("/salvar_usuario")
	public ModelAndView save (
			ModelMap model,
			@ModelAttribute("usuarioEntity") UsuarioEntity usuarioEntity,
			RedirectAttributes atributes)  throws Exception
	{
		System.out.println("Nome :" + usuarioEntity.getNome());
		System.out.println("Senha :" + usuarioEntity.getSenha());
		System.out.println("Telefone :" + usuarioEntity.getTelefone());
		System.out.println("Email :" + usuarioEntity.getEmail());
		
	ModelAndView mv = new ModelAndView("redirect:/loja");
	usuarioRepository.save(usuarioEntity);
	/*atributes.addFlashAttribute("mensagem", docenteService.save(docenteEntity));
	*/
	return mv;
	
	}
	
}
