package com.DAO;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import com.DTO.ProTory;
import com.DTO.Proveedor;
import com.Exception.ProEx;

public class ProSer {
	private ProTory repository;

    @Autowired
    public ProSer(ProTory repository) {
        this.repository = repository;
    }
    
    public Collection<Proveedor> ObtPro(){
        return repository.findAll();
    }   

    public Proveedor ObtPro(Long idpro){
        return repository.findById(idpro)
            .orElseThrow(() -> new ProEx(idpro));
    }

    public void AgrePro(Proveedor newpro) {
        repository.save(newpro);
    }

    public void ActPro(Proveedor proveedor) {
        repository
            .findById(proveedor.getIdpro())
            .ifPresent(p -> repository.save(proveedor));
    }

    public void BorPro(Long idpro) {
        Proveedor proveedor = ObtPro(idpro);
        repository.delete(proveedor);
    }    
}
