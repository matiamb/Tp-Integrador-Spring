
package com.javaspring.tpintegradorspring.repository;

import com.javaspring.tpintegradorspring.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends JpaRepository <Producto, Long>{
    
}
