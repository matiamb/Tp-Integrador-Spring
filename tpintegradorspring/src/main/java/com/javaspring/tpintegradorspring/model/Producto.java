
package com.javaspring.tpintegradorspring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    public Long codigo_producto;
    public String nombre;
    public String marca;
    public double costo;
    public double cantidad_disponible;
    
    @ManyToOne
    @JoinColumn (name = "codigo_venta")
    public Venta unaVenta;

    public Producto() {
    }

    public Producto(Long codigo_producto, String nombre, String marca, double costo, double cantidad_disponible, Venta unaVenta, Cliente unCli) {
        this.codigo_producto = codigo_producto;
        this.nombre = nombre;
        this.marca = marca;
        this.costo = costo;
        this.cantidad_disponible = cantidad_disponible;
        this.unaVenta = unaVenta;
    }

    
    
}
