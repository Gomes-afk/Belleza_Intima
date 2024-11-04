package br.com.belleza_intima.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.ObjectToStringHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.ui.ModelMapExtensionsKt;

import br.com.belleza_intima.entity.UsuarioEntity;
import br.com.belleza_intima.repository.UsuarioRepository;
import ch.qos.logback.core.model.Model;

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
	
	@GetMapping("/cadastro")
	public String usuario(ModelMap model) 
	{
		model.addAttribute("cadastrados",usuarioRepository.findAll()); //caminho real do arquivo
		return "cadastro";
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
		System.out.println("Cpf :" + usuarioEntity.getCpf());
		
	ModelAndView mv = new ModelAndView("redirect:/cadastro");
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
	@PutMapping("/alterar_usuario/{id}")
	public ResponseEntity<UsuarioEntity> updateUsuarioEntity(@PathVariable ("id") Long idUsuario, @RequestBody UsuarioEntity novoUsuario) {
	    // Sua lógica de atualização aqui
	    
	    // Se a atualização for bem-sucedida:
	    return ResponseEntity.ok(novoUsuario); // Retorna um status 200 com o objeto atualizado
	}


}
