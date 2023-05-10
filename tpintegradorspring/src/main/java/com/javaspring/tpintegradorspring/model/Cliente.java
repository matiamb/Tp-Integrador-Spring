
package com.javaspring.tpintegradorspring.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Cliente {
    
    private Long id_cliente;
    public String nombre;
    public String apellido;
    public String dni;

    public Cliente() {
    }

    public Cliente(Long id_cliente, String nombre, String apellido, String dni) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }
    
}
