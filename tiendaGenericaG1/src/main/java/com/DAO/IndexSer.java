package com.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.DTO.IndexTory;
import com.Security.Authority;


@Service
public class IndexSer implements UserDetailsService{
	@Autowired
	IndexTory repository;

	@Override
	public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {

		com.Security.UsuarioSecure Usuario = repository.findByUsuario(usuario)
				.orElseThrow(() -> new UsernameNotFoundException("Esta excepción está cubierta desde otro lugar"));

		List<GrantedAuthority> ListaAutoridades = new ArrayList<GrantedAuthority>();

		for (Authority autoridad : Usuario.getAuthority()) {

			GrantedAuthority autoridadObtenida = new SimpleGrantedAuthority(autoridad.getAuthority());

			ListaAutoridades.add(autoridadObtenida);

		}
		
		UserDetails resultadoUsuario = (UserDetails) new User(Usuario.getUsuario(), Usuario.getPassword(), ListaAutoridades);
		return resultadoUsuario;
		
	}
}
