
package com.javaspring.tpintegradorspring.controller;

import com.javaspring.tpintegradorspring.model.Producto;
import com.javaspring.tpintegradorspring.service.IProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoController {
    
    @Autowired
    private IProductoService prod_serv;
    
    @PostMapping ("/productos/crear")
    public void crearProducto(@RequestBody Producto prod){
        prod_serv.crearProducto(prod);
    }
    
    @GetMapping ("/productos")
    public List<Producto> traerProductos(){
        return prod_serv.traerProductos();
    }
    
    @GetMapping ("/productos/{id}")
    public Producto traerProd(@PathVariable Long id){
        return prod_serv.traerProd(id);
    }
    
    @DeleteMapping ("/productos/eliminar/{id}")
    public void borrarProducto(@PathVariable Long id){
        prod_serv.borrarProducto(id);
    }
    
    @PutMapping ("/productos/editar") //crea un producto nuevo en lugar de editarlo, posiblemente por lio con la id
    public void editarProducto(@RequestBody Producto prod){
        prod_serv.editarProducto(prod);
    }
    
}
