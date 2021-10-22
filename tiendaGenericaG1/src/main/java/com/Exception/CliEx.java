package com.Exception;

public class CliEx extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idcli;

    public CliEx(Long idcli) {
        super("No se encontró al cliente con la cédula " + idcli);
        this.idcli = idcli;
    }

    public Long getCedula() {
        return idcli;
    }
}
