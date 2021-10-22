package com.Exception;

public class UsuEx extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 private Long idusu;

    public UsuEx(Long idusu) {
        super("No se encontró al usuario con la cédula " + idusu);
        this.idusu = idusu;
    }

    public Long getCedula() {
        return idusu;
    }

}
