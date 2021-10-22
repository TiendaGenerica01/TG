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

import com.DAO.ProDAO;
import com.DAO.ProSer;
import com.DTO.ProTory;
import com.DTO.Proveedor;

//control proveedor
@Controller
@RestController
@ResponseBody
@RequestMapping("/proveedores")
public class Protroll {
	private final Logger logg= LoggerFactory.getLogger(Proveedor.class);
	@Autowired
	private ProTory proveedorRepository;
	
	@GetMapping("")
	public String proveedores(Model model) {
		model.addAttribute("proveedores", proveedorRepository.findAll());
		return "proveedores";
	}
	@GetMapping("/create") 
	public String create() {
		return "create";
	}
	
	@PostMapping("/save")
	public String save(Proveedor proveedor) {
		logg.info("Informacion del proveedor,{}",proveedor);
		proveedorRepository.save(proveedor);
		return "redirect:/proveedores";
	}
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Long idpro, Model model) {
		Proveedor p=proveedorRepository.getOne(idpro);
		logg.info("Objeto recuperado{}",p);
		model.addAttribute("producto",p);
		return "edit";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long idpro) {
		Proveedor p=proveedorRepository.getOne(idpro);
		logg.info("Objeto eliminado{}",p);
		proveedorRepository.delete(p);
		return "redirect:/proveedores";
	}
}
