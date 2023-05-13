
package com.javaspring.tpintegradorspring.repository;

import com.javaspring.tpintegradorspring.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends JpaRepository <Cliente, Long>{
    
}
