
package com.javaspring.tpintegradorspring.service;

import com.javaspring.tpintegradorspring.model.Cliente;
import com.javaspring.tpintegradorspring.repository.IClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService {
    
    @Autowired
    IClienteRepository clienterepo;

    @Override
    public void crearCliente(Cliente cli) {
        clienterepo.save(cli);
    }

    @Override
    public List<Cliente> traerClientes() {
        return clienterepo.findAll();
    }

    @Override
    public Cliente traerUnCliente(Long id) {
        return clienterepo.findById(id).orElse(null);
    }

    @Override
    public void eliminarCliente(Long id) {
        clienterepo.deleteById(id);
    }

    @Override
    public void editarCliente(Cliente cli) {
        this.crearCliente(cli);
    }
    
}
