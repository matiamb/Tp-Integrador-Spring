
package com.javaspring.tpintegradorspring.controller;

import com.javaspring.tpintegradorspring.model.Venta;
import com.javaspring.tpintegradorspring.service.VentaService;
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
public class VentaController {
    
    @Autowired
    VentaService ventasvs;
    
    @PostMapping ("/ventas/crear")
    public String crearVenta(@RequestBody Venta vta){
        ventasvs.crearVenta(vta);
        return "Venta creada con exito";
    }
    
    @GetMapping ("/ventas")
    public List<Venta> traerVentas(){
        return ventasvs.traerVentas();
    }
    
    @GetMapping ("/ventas/{id}")
    public Venta traerUnaVenta(@PathVariable Long id){
        return ventasvs.traerUnaVenta(id);
    }
    
    @DeleteMapping ("/ventas/{id}")
    public String borrarVenta(@PathVariable Long id){
        return "Venta borrada con exito";
    }
    
    @PutMapping ("/ventas/editar")
    public Venta editarVenta(@RequestBody Venta vta){
        ventasvs.editarVenta(vta);
        return ventasvs.traerUnaVenta(vta.getCodigo_venta());
    }
    
}
