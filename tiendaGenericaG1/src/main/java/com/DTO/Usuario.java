package com.DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//origen datos proyecto
@Entity
@Table(name = "usuarios")
public class Usuario {
	@Id
    @Column(name = "cedula_usuario")
	private Long idusu;
	@Column(name = "email_usuario")
	private String mailusu;
	@Column(name = "nombre_usuario")
	private String nomusu;
	@Column(name = "password")
	private String pass;
	@Column(name = "usuario")
	private String ario;
	
	public Usuario(Long idusu, String mailusu, String nomusu, String pass, String ario) {
		super();
		this.idusu = idusu;
		this.mailusu = mailusu;
		this.nomusu = nomusu;
		this.pass = pass;
		this.ario = ario;
		
	}
	
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdusu() {
		return idusu;
	}
	public void setIdusu(Long idusu) {
		this.idusu = idusu;
	}
	public String getMailusu() {
		return mailusu;
	}
	public void setMailusu(String mailusu) {
		this.mailusu = mailusu;
	}
	public String getNomusu() {
		return nomusu;
	}
	public void setNomusu(String nomusu) {
		this.nomusu = nomusu;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getArio() {
		return ario;
	}
	public void setArio(String ario) {
		this.ario = ario;
	}
	
	@Override
    public String toString() {
        return "Usuario [Cedula Usuario=" + idusu + ", Nombre Usuario=" + nomusu + ", Email Usuario=" + mailusu + ", Password Usuario=" + pass
                + ", Usuario =" + ario + "]";
    }
}
