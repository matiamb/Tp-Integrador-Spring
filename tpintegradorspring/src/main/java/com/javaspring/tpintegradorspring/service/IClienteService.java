
package com.javaspring.tpintegradorspring.service;

import com.javaspring.tpintegradorspring.model.Cliente;
import java.util.List;


public interface IClienteService {
    public void crearCliente(Cliente cli);
    public List<Cliente> traerClientes();
    public Cliente traerUnCliente(Long id);
    public void eliminarCliente(Long id);
    public void editarCliente(Cliente cli);
}
