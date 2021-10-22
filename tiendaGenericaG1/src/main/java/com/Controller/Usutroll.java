package com.Controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.DAO.UsuDAO;
import com.DAO.UsuSer;
import com.DTO.UsuTory;
import com.DTO.Usuario;

//control usuario
@Controller
@RestController
@ResponseBody
@RequestMapping("/usuarios")
public class Usutroll {
	private final Logger logg= LoggerFactory.getLogger(Usuario.class);
	@Autowired
	private UsuTory usuarioRepository;
	
	@GetMapping("")
	public String usuarios(Model model) {
		model.addAttribute("usuarios", usuarioRepository.findAll());
		return "usuarios";
	}
	@GetMapping("/create") 
	public String create() {
		return "create";
	}
	
	@PostMapping("/save")
	public String save(Usuario usuario) {
		logg.info("Informacion del usuario,{}",usuario);
		usuarioRepository.save(usuario);
		return "redirect:/usuarios";
	}
	@GetMapping("/edit/{idusu}")
	public String edit(@PathVariable Long idusu, Model model) {
		Usuario u=usuarioRepository.getOne(idusu);
		logg.info("Objeto recuperado{}",u);
		model.addAttribute("usuario",u);
		return "edit";
	}

	@GetMapping("/delete/{idusu}")
	public String delete(@PathVariable Long idusu) {
		Usuario u=usuarioRepository.getOne(idusu);
		logg.info("Objeto eliminado{}",u);
		usuarioRepository.delete(u);
		return "redirect:/usuarios";
	}
}
