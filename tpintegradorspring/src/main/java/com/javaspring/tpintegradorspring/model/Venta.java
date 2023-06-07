
package com.javaspring.tpintegradorspring.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
    @ManyToMany
    @JoinTable (name = "Venta_producto",
            joinColumns = @JoinColumn (name = "id_venta"),
            inverseJoinColumns = @JoinColumn (name = "id_producto"))
    public List<Producto> listaProductos;
    @ManyToOne
    @JsonIgnoreProperties ("ventas")
    public Cliente cliente;
    
    
    public Venta() {
    }

    public Venta(Long codigo_venta, LocalDate fecha_venta, double total, List<Producto> listaProductos, Cliente cliente) {
        this.codigo_venta = codigo_venta;
        this.fecha_venta = fecha_venta;
        this.total = total;
        this.listaProductos = listaProductos;
        this.cliente = cliente;
    }
    
}
