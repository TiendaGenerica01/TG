package com.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Apptroll {
	@GetMapping({"/","/login"})
	public String index() {
		return "index";
	}
	@GetMapping({"/menu"})
	public String menu() {
		return "menu";
	}
	@GetMapping({"/usuarios"})
	public String usuarios() {
		return "usuarios";
	}
	@GetMapping({"/clientes"})
	public String clientes() {
		return "clientes";
	}
	@GetMapping({"/proveedores"})
	public String proveedores() {
		return "proveedores";
	}
	@GetMapping({"/productos"})
	public String productos() {
		return "productos";
	}
	@GetMapping({"/ventas"})
	public String ventas() {
		return "ventas";
	}
	@GetMapping({"/reportes"})
	public String reportes() {
		return "reportes";
	}
}
