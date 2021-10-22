package com.DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {
	@Id
	@Column(name = "cedula_cliente")
	private Long idcli;
	@Column(name = "direccion_cliente")
	private String dircli;
	@Column(name = "email_cliente")
	private String mailcli;
	@Column(name = "nombre_cliente")
	private String nomcli;
	@Column(name = "telefono_cliente")
	private String telcli;
	
	public Cliente(Long idcli, String dircli, String mailcli, String nomcli, String telcli) {
		super();
		this.idcli = idcli;
		this.dircli = dircli;
		this.mailcli = mailcli;
		this.nomcli = nomcli;
		this.telcli = telcli;
	}
	
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdcli() {
		return idcli;
	}

	public void setIdcli(Long idcli) {
		this.idcli = idcli;
	}

	public String getDircli() {
		return dircli;
	}

	public void setDircli(String dircli) {
		this.dircli = dircli;
	}

	public String getMailcli() {
		return mailcli;
	}

	public void setMailcli(String mailcli) {
		this.mailcli = mailcli;
	}

	public String getNomcli() {
		return nomcli;
	}

	public void setNomcli(String nomcli) {
		this.nomcli = nomcli;
	}

	public String getTelcli() {
		return telcli;
	}

	public void setTelcli(String telcli) {
		this.telcli = telcli;
	}
	
	@Override
    public String toString() {
        return "Cliente [ID=" + idcli + ", Direccion Cliente=" + dircli + ", Email Cliente=" + mailcli + ", Nombre Cliente=" + nomcli
                + ", Telefono Cliente =" + telcli + "]";
    }
	
}
