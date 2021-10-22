package com.Controller;

import java.util.ArrayList;
import java.util.Collection;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.DAO.CliDAO;
import com.DAO.CliSer;
import com.DTO.CliTory;
import com.DTO.Cliente;

//control cliente
@Controller
@RestController
@ResponseBody
@RequestMapping("/clientes")
public class Clitroll {
	private final Logger logg= LoggerFactory.getLogger(Cliente.class);
	@Autowired
	private CliTory clienteRepository;
	
	@GetMapping("")
	public String clientes(Model model) {
		model.addAttribute("clientes", clienteRepository.findAll());
		return "clientes";
	}
	@GetMapping("/create") 
	public String create() {
		return "create";
	}
	
	@PostMapping("/save")
	public String save(Cliente cliente) {
		logg.info("Informacion del cliente,{}",cliente);
		clienteRepository.save(cliente);
		return "redirect:/clientes";
	}
	@GetMapping("/edit/{idcli}")
	public String edit(@PathVariable Long idcli, Model model) {
		Cliente c=clienteRepository.getOne(idcli);
		logg.info("Objeto recuperado{}",c);
		model.addAttribute("producto",c);
		return "edit";
	}

	@GetMapping("/delete/{idcli}")
	public String delete(@PathVariable Long idcli) {
		Cliente c=clienteRepository.getOne(idcli);
		logg.info("Objeto eliminado{}",c);
		clienteRepository.delete(c);
		return "redirect:/productos";
	}
}
