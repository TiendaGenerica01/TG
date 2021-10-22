package com.DTO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuTory extends JpaRepository<Usuario, Long>{
	@Query(value="Select * from usuarios usuario where usuario.cedula_usuario like %:idusu%", nativeQuery=true)
    List<Usuario> findByCedulaContaining(String idusu);

}
