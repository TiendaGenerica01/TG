package com.DTO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProTory extends JpaRepository<Proveedor, Long>{

}
