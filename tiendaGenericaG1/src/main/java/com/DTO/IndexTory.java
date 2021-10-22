package com.DTO;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


public interface IndexTory extends CrudRepository <com.Security.UsuarioSecure , Long>{
	public Optional<com.Security.UsuarioSecure> findByUsuario(String usuario);
}
