
package com.javaspring.tpintegradorspring.service;

import com.javaspring.tpintegradorspring.model.Producto;
import java.util.List;


public interface IProductoService {
    
    public void crearProducto(Producto prod);
    public List<Producto> traerProductos();
    public Producto traerProd(Long id);
    public void borrarProducto(Long id);
    public void editarProducto(Producto prod);
    
}
