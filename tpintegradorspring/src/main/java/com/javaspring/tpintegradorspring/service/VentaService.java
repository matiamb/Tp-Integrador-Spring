
package com.javaspring.tpintegradorspring.service;

import com.javaspring.tpintegradorspring.model.Venta;
import com.javaspring.tpintegradorspring.repository.IVentaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService implements IVentaService{
    
    @Autowired
    IVentaRepository ventarepo;

    @Override
    public void crearVenta(Venta venta) {
        ventarepo.save(venta);
    }

    @Override
    public List<Venta> traerVentas() {
        return ventarepo.findAll();
    }

    @Override
    public Venta traerUnaVenta(Long id) {
        return ventarepo.findById(id).orElse(null);
    }

    @Override
    public void eliminarVenta(Long id) {
        ventarepo.deleteById(id);
    }

    @Override
    public void editarVenta(Venta vta) {
        this.crearVenta(vta);
    }
    
}
