
package com.javaspring.tpintegradorspring.service;

import com.javaspring.tpintegradorspring.model.Venta;
import java.util.List;


public interface IVentaService {
    
    public void crearVenta(Venta venta);
    public List<Venta> traerVentas();
    public Venta traerUnaVenta(Long id);
    public void eliminarVenta(Long id);
    public void editarVenta(Venta vta);
    
}
