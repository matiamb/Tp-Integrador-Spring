
package com.javaspring.tpintegradorspring.controller;

import com.javaspring.tpintegradorspring.model.Producto;
import com.javaspring.tpintegradorspring.model.Venta;
import com.javaspring.tpintegradorspring.service.VentaService;
import java.time.LocalDate;
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
        for (Producto p : vta.getListaProductos() ){
            if(p.cantidad_disponible > 0){
        ventasvs.crearVenta(vta);
        return "Venta creada con exito";
            }
            else{
                return "No hay suficiente stock";
            }
        }       
        return null;
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
    
    @GetMapping ("/ventas/productos/{id_venta}")
    public List<Producto> traerProductos(@PathVariable Long id_venta){
        Venta temp = ventasvs.traerUnaVenta(id_venta);
        return temp.listaProductos;
    }
    
    @GetMapping ("/ventas/dia/{fecha_venta}")
    public String ventasDelDia(@PathVariable LocalDate fecha_venta){
        List<Venta> temp = ventasvs.traerVentas();
        int contador = 0;
        int total = 0;
        for (Venta v : temp){
            if (fecha_venta == v.getFecha_venta()){
                contador += 1;
                total += v.getTotal();                
            }
            System.out.println(v.getFecha_venta());
        }
        return "El dia " + fecha_venta + " hubo " + contador + " ventas. El total recaudado en el dia es de " + total;
    }
    
}
