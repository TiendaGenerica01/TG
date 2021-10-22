package com.Security;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Usuariotory extends CrudRepository<UsuarioSecure, Long>{
	public Optional<UsuarioSecure> findByUsername(String Usuario);
}
