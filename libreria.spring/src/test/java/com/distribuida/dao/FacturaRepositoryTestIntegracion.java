package com.distribuida.dao;

import com.distribuida.model.Cliente;
import com.distribuida.model.Factura;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@Rollback(value = false)
public class FacturaRepositoryTestIntegracion {

    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    public void findAll(){
        List<Factura> facturas = facturaRepository.findAll();
        assertNotNull(facturas);
        assertTrue(facturas.size()>0);
        for(Factura item: facturas){
            System.out.println(item.toString());
        }
    }

    @Test
    public void findOne(){
        Optional<Factura> factura = facturaRepository.findById(82);
        assertNotNull(factura);
        assertEquals("FAC-0061",factura.orElse(null).getNumFactura());
        System.out.println(factura.toString());
    }

    @Test
    public void save(){
        Optional<Cliente> cliente = clienteRepository.findById(1);
        assertTrue(cliente.isPresent());
        Factura factura = new Factura();
        factura.setIdFactura(0);
        factura.setNumFactura("FAC-00083");
        factura.setFecha(new Date());
        factura.setTotalNeto(100.00);
        factura.setIva(15.00);
        factura.setTotal(115.00);
        factura.setCliente(cliente.orElse(null));

        Factura facturaGuardada = facturaRepository.save(factura);
        assertNotNull(facturaGuardada);
        assertEquals("FAC-00083", facturaGuardada.getNumFactura());
        assertEquals(115.00, facturaGuardada.getTotal());
    }

    @Test
    public void update(){
        Optional<Factura> facturaExistente = facturaRepository.findById(86);
        Optional<Cliente> clienteExistente = clienteRepository.findById(2);

        assertNotNull(facturaExistente);
        assertNotNull(clienteExistente);

        facturaExistente.orElse(null).setNumFactura("FAC00099");
        facturaExistente.orElse(null).setFecha(new Date());
        facturaExistente.orElse(null).setTotalNeto(200.00);
        facturaExistente.orElse(null).setIva(30.00);
        facturaExistente.orElse(null).setTotal(230.00);
        facturaExistente.orElse(null).setCliente(clienteExistente.orElse(null));

        Factura facturaActualizada = facturaRepository.save(facturaExistente.orElse(null));

        assertNotNull(facturaActualizada);
        assertEquals("FAC00099", facturaActualizada.getNumFactura());

    }
    @Test
    public void delete(){
        if(facturaRepository.existsById(86)){
            facturaRepository.deleteById(86);
        }
        assertFalse(facturaRepository.existsById(86));
    }

}
