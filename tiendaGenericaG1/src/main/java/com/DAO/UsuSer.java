package com.DAO;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import com.DTO.UsuTory;
import com.DTO.Usuario;
import com.Exception.UsuEx;


public class UsuSer {
	 private final UsuTory repository;

	    @Autowired
	    public UsuSer(UsuTory repository) {
	        this.repository = repository;
	    }

	    public Collection<Usuario> getUsuarios(String filtroId) {        
	        return repository.findByCedulaContaining(filtroId);
	    }

	    public Usuario getUsuario(Long idusu) {
	        return repository.findById(idusu)
	            .orElseThrow(() -> new UsuEx(idusu));
	    }

	    public void AgreUsu(Usuario newusu) {           
	        repository.save(newusu);
	    }

	    public void ActUsu(Usuario usuario) {
	        repository.findById(usuario.getIdusu())
	            .ifPresent(user -> {
	                user.setMailusu(usuario.getMailusu());
	                user.setNomusu(usuario.getNomusu());
	                user.setPass(usuario.getPass());
	                user.setArio(usuario.getArio());            
	            });

	        repository.save(usuario);
	    }

	    public void BorUsu(Long idusu){
	        Usuario user = getUsuario(idusu);
	        repository.delete(user);
	    }
}
