
package com.javaspring.tpintegradorspring.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Producto {
    
    private Long codigo_producto;
    public String nombre;
    public String marca;
    public double costo;
    public double cantidad_disponible;

    public Producto() {
    }

    public Producto(Long codigo_producto, String nombre, String marca, double costo, double cantidad_disponible) {
        this.codigo_producto = codigo_producto;
        this.nombre = nombre;
        this.marca = marca;
        this.costo = costo;
        this.cantidad_disponible = cantidad_disponible;
    }
    
}
