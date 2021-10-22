package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.DAO.UsuDAO;
import com.DTO.Usuario;

@Controller
public class Logintroll {
	
	@Autowired
	private UsuDAO usu;
	
	@GetMapping({"/","/Index"})
	public String Ingreso(Model modelo) {
		
		List<Usuario> FilasUsuarios = usu.liusu();
		
		if( FilasUsuarios.size() == 0 ) {
			
			//Recuperacion del usuario inicial
			usu.regusu(0, "adini@gmail.com", "admin", "admin123456", "admininicial");
			
		}
		
		return "/index";
		
	}

}
