
package com.javaspring.tpintegradorspring.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MayorVentaDTO {
    private Long codigo_venta;
    private double total;
    private int cant_prods;
    private String nombre;
    private String apellido;

    public MayorVentaDTO() {
    }

    public MayorVentaDTO(Long codigo_venta, double total, int cant_prods, String nombre, String apellido) {
        this.codigo_venta = codigo_venta;
        this.total = total;
        this.cant_prods = cant_prods;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
}
