
package com.javaspring.tpintegradorspring.controller;

import com.javaspring.tpintegradorspring.model.Producto;
import com.javaspring.tpintegradorspring.service.IProductoService;
import java.util.ArrayList;
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
    public String crearProducto(@RequestBody Producto prod){
        prod_serv.crearProducto(prod);
        return "Producto creado con exito";
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
    public String borrarProducto(@PathVariable Long id){
        prod_serv.borrarProducto(id);
        return "Producto borrado con exito";
    }
    
    @PutMapping ("/productos/editar")
    public Producto editarProducto(@RequestBody Producto prod){
        prod_serv.editarProducto(prod);
        return prod_serv.traerProd(prod.getCodigo_producto());
    }
    
    @GetMapping ("/productos/falta_stock")
    public List<Producto> getFaltaStock(){
        List<Producto> prods = new ArrayList<>();
        for (Producto prod : prod_serv.traerProductos()){
            if (prod.getCantidad_disponible() < 5){
                prods.add(prod);
                System.out.println("producto agregado");
            }
        }
        return prods;
    }
    
}
