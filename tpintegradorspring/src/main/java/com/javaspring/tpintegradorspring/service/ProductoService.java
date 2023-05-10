
package com.javaspring.tpintegradorspring.service;

import com.javaspring.tpintegradorspring.model.Producto;
import com.javaspring.tpintegradorspring.repository.IProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService {
    
    @Autowired
    private IProductoRepository prod_repo;
    
    @Override
    public void crearProducto(Producto prod) {
        prod_repo.save(prod);
    }
    
    @Override
    public List<Producto> traerProductos() {
        List<Producto> productos = prod_repo.findAll();
        return productos;
    }

    @Override
    public Producto traerProd(Long id) {
        Producto producto = prod_repo.findById(id).orElse(null);
        return producto;
    }

    @Override
    public void borrarProducto(Long id) {
        prod_repo.deleteById(id);
    }

    @Override
    public void editarProducto(Producto prod) {
        this.crearProducto(prod);
    }

    
    
}
