package com.distribuida.service;

import com.distribuida.dao.ClienteRepository;
import com.distribuida.model.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceTestUnitaria {



    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteServiceImpl clienteService;

    private Cliente cliente;

    @BeforeEach
    public void setUp(){
        cliente = new Cliente();
        cliente.setIdCliente(1);
        cliente.setCedula("1716699515");
        cliente.setNombre("Juan");
        cliente.setApellido("Albuja");
        cliente.setDireccion("Av. Gonzales Suarez");
        cliente.setTelefono("0984443806");
        cliente.setCorreo("juan.albuja@gmail.com");


    }
    @Test
    public void testFindAll(){
        when(clienteRepository.findAll()).thenReturn(List.of(cliente));
        List<Cliente> clientes = clienteService.findAll();
        assertNotNull(clientes);
        assertEquals(1,clientes.size());
        verify(clienteRepository,times(1));
    }

    @Test
    public void testFindOneExistente(){
        when(clienteRepository.findById(1)).thenReturn(Optional.ofNullable(cliente));
        Cliente cliente = clienteService.findOne(1);
        assertNotNull(cliente);
        assertEquals("Juan",cliente.getNombre());
    }

    @Test
    public void testFindOneNoExistente(){
        when(clienteRepository.findById(2)).thenReturn(Optional.empty());
        Cliente cliente = clienteService.findOne(2);
        assertNull(cliente);
    }

    @Test
    public void testSave(){
        when(clienteRepository.save(cliente)).thenReturn(cliente);
        Cliente cliente1 = clienteService.save(cliente);
        assertNotNull(cliente1);
        assertEquals("Juan",cliente1.getNombre());
    }

    @Test
    public void testUpdateExistente(){
        Cliente clienteActualizado = new Cliente();
        clienteActualizado.setCedula("1714885520");
        clienteActualizado.setNombre("Juan22");
        clienteActualizado.setApellido("Apellido22");
        clienteActualizado.setDireccion("Av. 222");
        clienteActualizado.setTelefono("095445566");
        clienteActualizado.setCorreo("juan.apellido22@correo.com");

        when(clienteRepository.findById(1)).thenReturn(Optional.ofNullable(cliente));
        when(clienteRepository.save(any())).thenReturn(clienteActualizado);

        Cliente clienteResultado = clienteService.update(1,clienteActualizado);
        assertNotNull(clienteResultado);
        assertEquals("Juan22",clienteResultado.getNombre());
        verify(clienteRepository,times(1)).save(cliente);
    }
    @Test
    public void testUpdateNoExistente(){
        Cliente clienteNuevo = new Cliente();
        when(clienteRepository.findById(999)).thenReturn(Optional.empty());
        Cliente clienteResultado = clienteService.update(999, clienteNuevo);

        assertNull(clienteResultado);
        assertEquals("Juan22",clienteResultado.getNombre());
        verify(clienteRepository,times(0)).save(any());
    }

    @Test
    public void testDeleteExistente(){
        when(clienteRepository.existsById(1)).thenReturn(true);
        clienteService.delete(1);
        verify(clienteRepository).deleteById(1);
    }

    @Test
    public void testDeleteNoExistente(){
        when(clienteRepository.existsById(999)).thenReturn(false);
        clienteService.delete(999);
        verify(clienteRepository,never()).deleteById(anyInt());

    }
}