package com.Exception;

public class ProEx extends RuntimeException{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idpro;

    public ProEx(Long idpro) {
        super("No se encontró al proveedor con nit " + idpro);
        this.idpro = idpro;
    }

    public Long getNit() {
        return idpro;
    }
}
