
package com.javaspring.tpintegradorspring.controller;

import com.javaspring.tpintegradorspring.model.Cliente;
import com.javaspring.tpintegradorspring.service.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {
    @Autowired
    ClienteService clientesvs;
    
    @PostMapping ("/clientes/crear")
    public String crearCliente(@RequestBody Cliente cli){
        clientesvs.crearCliente(cli);
        return "Cliente creado con exito";
    }
    
    @GetMapping ("/clientes")
    public List<Cliente> traerClientes(){
        return clientesvs.traerClientes();
    }
    
    @GetMapping ("/clientes/{id}")
    public Cliente traerUnCliente(@PathVariable Long id){
        return clientesvs.traerUnCliente(id);
    }
    
    @DeleteMapping ("/clientes/eliminar/{id}")
    public String eliminarCliente(@PathVariable Long id){
        clientesvs.eliminarCliente(id);
        return "Cliente eliminado con exito";
    }
    
    @PutMapping ("/clientes/editar")
    public Cliente editarCliente(@RequestBody Cliente cli){
        clientesvs.editarCliente(cli);
        return clientesvs.traerUnCliente(cli.getId_cliente());
    }
}
