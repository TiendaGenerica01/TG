package com.DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="proveedores")
public class Proveedor {
	@Id
    @Column(name="nitproveedor")
	private Long idpro;
	@Column(name="ciudad_proveedor")
	private String ciupro;
	@Column(name="direccion_proveedor")
	private String dirpro;
	@Column(name="nombre_proveedor")
	private String nompro;
	@Column(name="telefono_proveedor")
	private String telpro;
	
	public Proveedor(Long idpro, String ciupro, String dirpro, String nompro, String telpro) {
		super();
		this.idpro = idpro;
		this.ciupro = ciupro;
		this.dirpro = dirpro;
		this.nompro = nompro;
		this.telpro = telpro;
	}
	
	public Proveedor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdpro() {
		return idpro;
	}
	public void setIdpro(Long idpro) {
		this.idpro = idpro;
	}
	public String getCiupro() {
		return ciupro;
	}
	public void setCiupro(String ciupro) {
		this.ciupro = ciupro;
	}
	public String getDirpro() {
		return dirpro;
	}
	public void setDirpro(String dirpro) {
		this.dirpro = dirpro;
	}
	public String getNompro() {
		return nompro;
	}
	public void setNompro(String nompro) {
		this.nompro = nompro;
	}
	public String getTelpro() {
		return telpro;
	}
	public void setTelpro(String telpro) {
		this.telpro = telpro;
	}
	
	@Override
    public String toString() {
        return "Proveedor [Ciudad Proveedor=" + ciupro + ", Direccion Proveedor=" + dirpro + ", Nombre Proveedor=" + nompro
                + ", Telefono Proveedor=" + telpro + "]";
    }  
}
