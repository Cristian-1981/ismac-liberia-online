package com.distribuida.dao;

import com.distribuida.model.Cliente;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@Rollback(value = false)

public class ClienteRepositoryTestIntegracion {

    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    public void findAll(){
        List<Cliente> clientes = clienteRepository.findAll();
        assertNotNull(clientes);
        assertTrue(clientes.size()>0);
        for(Cliente item: clientes){
            System.out.println(item.toString());
        }
    }

    @Test
    public void findOne(){
        Optional<Cliente> cliente = clienteRepository.findById(1);
        assertTrue(cliente.isPresent());
        System.out.println(cliente.toString());
    }
    
    @Test
    public void save (){
        Cliente cliente = new Cliente(0,"1716699515","Carlos","Sainz","Av Mallorca","0985663355","carlossainz@williams.com");
        Cliente clienteguardado = clienteRepository.save(cliente);
        assertNotNull(clienteguardado);
        assertEquals("Carlos",clienteguardado.getNombre());
        assertEquals("Sainz",clienteguardado.getApellido());
    }

    @Test
    public void update(){
        Optional<Cliente> cliente = clienteRepository.findById(40);
        assertTrue(cliente.isPresent(),"El cliente con id = 40 deberia existir");
        cliente.orElse(null).setCedula("1714885566");
        cliente.orElse(null).setNombre("Alex");
        cliente.orElse(null).setApellido("Albon");
        cliente.orElse(null).setDireccion("Av. Gar");
        cliente.orElse(null).setTelefono("09846622596");
        cliente.orElse(null).setCorreo("alexalbon@williams.com");
        Cliente clienteactualizado = clienteRepository.save(cliente.orElse(null));
        assertNotNull(clienteactualizado);
        assertEquals("Alex", clienteactualizado.getNombre());
        assertEquals("Albon", clienteactualizado.getApellido());
    }

    @Test
    public void delete(){
        if(clienteRepository.existsById(40)){
            clienteRepository.deleteById(40);
        }
        assertFalse(clienteRepository.existsById(40),"El id = 40 debia eliminarse");
    }
}
