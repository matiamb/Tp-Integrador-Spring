
package com.javaspring.tpintegradorspring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Venta {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long codigo_venta;
    public LocalDate fecha_venta;
    public double total;
    public List<Producto> listaProductos;
    public Cliente unCliente;
    
    @OneToMany
    public List<Producto> productosVta;
    
    @OneToOne
    @JoinColumn(name = "id_cliente", 
            referencedColumnName = "id_cliente")
    public Cliente cliente;
    
    public Venta() {
    }

    public Venta(Long codigo_venta, LocalDate fecha_venta, double total, List<Producto> listaProductos, Cliente unCliente, List<Producto> productosVta, Cliente cliente) {
        this.codigo_venta = codigo_venta;
        this.fecha_venta = fecha_venta;
        this.total = total;
        this.listaProductos = listaProductos;
        this.unCliente = unCliente;
        this.productosVta = productosVta;
        this.cliente = cliente;
    }
    
}
