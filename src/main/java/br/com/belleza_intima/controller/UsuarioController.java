package br.com.belleza_intima.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.ObjectToStringHttpMessageConverter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.ui.ModelMapExtensionsKt;

import br.com.belleza_intima.entity.PermissaoEntity;
import br.com.belleza_intima.entity.UsuarioEntity;
import br.com.belleza_intima.repository.PermissaoRepository;
import br.com.belleza_intima.repository.UsuarioRepository;
import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PermissaoRepository permissaoRepository;
	
	@GetMapping("/cadastro")
	public String usuario(ModelMap model) 
	{
		model.addAttribute("cadastrados",usuarioRepository.findAll()); //caminho real do arquivo
		return "cadastro";
	}
	@GetMapping("/cadastroadm")
	public String cadastroadm(ModelMap model) 
	{
		model.addAttribute("cadastrados",usuarioRepository.findAll()); //caminho real do arquivo
		return "cadastroadm";
	}
	@GetMapping("/perfil")
	public String perfil(ModelMap model,HttpSession session) 
	{
		String login = (String)session.getAttribute("login");
		System.out.println("login"+login);
		model.addAttribute("cadastrados",usuarioRepository.getOneByCpf(login)); //caminho real do arquivo
		return "perfil";
	}
	
	
	@PostMapping("/salvar_usuario")
	public ModelAndView save (
			ModelMap model,
			@ModelAttribute("usuarioEntity") UsuarioEntity usuarioEntity,
			RedirectAttributes atributes)  throws Exception
	{
		BCryptPasswordEncoder b = new BCryptPasswordEncoder();
		System.out.println("Nome :" + usuarioEntity.getNome());
		System.out.println("Senha :" + usuarioEntity.getSenha());
		usuarioEntity.setSenha(b.encode(usuarioEntity.getSenha()));
		System.out.println("Telefone :" + usuarioEntity.getTelefone());
		System.out.println("Email :" + usuarioEntity.getEmail());
		System.out.println("Cpf :" + usuarioEntity.getCpf());
		
	
	ModelAndView mv = new ModelAndView("redirect:/cadastro");
	//gambiarra
	List<Long> id = new ArrayList<>();
	id.add(2L);
	List<PermissaoEntity> permissoes = permissaoRepository.findAllById(id);
	
	usuarioEntity.setPermissoes(permissoes);
	usuarioRepository.save(usuarioEntity);
	/*atributes.addFlashAttribute("mensagem", docenteService.save(docenteEntity));
	*/
	return mv;
	
	}
	@GetMapping("/excluir_usuario/{id}")
	public ModelAndView delete (ModelMap model, @PathVariable("id") Long idUsuario,RedirectAttributes atributes) throws Exception
{
	ModelAndView mv = new ModelAndView("cadastro");
	try {
		usuarioRepository.deleteById(idUsuario);
		model.addAttribute("mensagem", "Usuario excluído com sucesso.");
		model.addAttribute("cadastrados",usuarioRepository.findAll());
	} 
	catch (Exception e) {
		throw new Exception(e.getMessage());
	}
	return mv;
	
}
	@GetMapping("/alterar_usuario/{id}")
	public ModelAndView consultarUsuario(ModelMap model,@PathVariable("id") Long idUsuario)
	{
		ModelAndView mv = new ModelAndView("alterar_usuario");
		model.addAttribute("id",idUsuario);		
		model.addAttribute("usuario",usuarioRepository.findById(idUsuario).get());
		
		
		return mv;
	}
	
	@PostMapping("/alterar_usuario")
	public String alterarusuario(ModelMap model,UsuarioEntity usuarioModel,RedirectAttributes atributes)
	{
		BCryptPasswordEncoder b = new BCryptPasswordEncoder();
		UsuarioEntity s = new UsuarioEntity();
		s = usuarioRepository.findById(usuarioModel.getId_usuario()).get();
		s.setNome(usuarioModel.getNome());
		s.setSenha(b.encode(usuarioModel.getSenha()));
		s.setTelefone(usuarioModel.getTelefone());
		s.setEmail(usuarioModel.getEmail());
		s.setCpf(usuarioModel.getCpf());

		usuarioRepository.saveAndFlush(s);
		atributes.addFlashAttribute("mensagem", "Usuário alterado com sucesso.");
		
		return "redirect:cadastro";
	}
}
