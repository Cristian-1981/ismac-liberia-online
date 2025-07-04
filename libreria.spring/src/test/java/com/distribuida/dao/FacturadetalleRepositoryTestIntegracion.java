package com.distribuida.dao;

import com.distribuida.model.Autor;
import com.distribuida.model.Factura;
import com.distribuida.model.Facturadetalle;
import com.distribuida.model.Libro;
import jakarta.transaction.Transactional;
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

public class FacturadetalleRepositoryTestIntegracion {

    @Autowired
    private FacturadetalleRepository facturadetalleRepository;

    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private LibroRepository libroRepository;

    @Test
    public void findAll(){
        List<Facturadetalle>  facturadetalles = facturadetalleRepository.findAll();
        assertNotNull(facturadetalles);
        assertTrue(facturadetalles.size()>0);
        for(Facturadetalle item: facturadetalles){
            System.out.println(item.toString());
        }
    }

    @Test
    public void findOne(){
        Optional<Facturadetalle> facturadetalle = facturadetalleRepository.findById(206);
        assertNotNull(facturadetalle);
        assertEquals(3,facturadetalle.orElse(null).getCantidad());
        System.out.println(facturadetalle.toString());
    }

    @Test
    public void save(){
        Optional<Factura> factura = facturaRepository.findById(1);
        assertTrue(factura.isPresent());
        Optional<Libro> libro = libroRepository.findById(1);
        assertTrue(libro.isPresent());

        Facturadetalle facturadetalle = new Facturadetalle();
        facturadetalle.setIdFacturadetalle(0);
        facturadetalle.setCantidad(5);
        facturadetalle.setSubtotal(50.25);
        facturadetalle.setFactura(factura.orElse(null));
        facturadetalle.setLibro(libro.orElse(null));

        Facturadetalle facturadetalleGuardada = facturadetalleRepository.save(facturadetalle);
        assertNotNull(facturadetalleGuardada);
        assertEquals(5, facturadetalleGuardada.getCantidad());
        assertEquals(50.25, facturadetalleGuardada.getSubtotal());
    }

    @Test
    public void update(){
        Optional<Facturadetalle> facturadetalleExistente = facturadetalleRepository.findById(206);
        Optional<Factura> facturaExistente = facturaRepository.findById(2);

        assertNotNull(facturadetalleExistente);
        assertNotNull(facturaExistente);

        facturadetalleExistente.orElse(null).setCantidad(6);
        facturadetalleExistente.orElse(null).setSubtotal(105.99);
        facturadetalleExistente.orElse(null).setFactura(facturaExistente.orElse(null));

        Facturadetalle facturadetalleActualizada = facturadetalleRepository.save(facturadetalleExistente.orElse(null));

        assertNotNull(facturadetalleActualizada);
        assertEquals(6, facturadetalleActualizada.getCantidad());

    }

    @Test
    public void delete(){
        if(facturadetalleRepository.existsById(210)){
            facturadetalleRepository.deleteById(210);
        }
        assertFalse(facturadetalleRepository.existsById(210));
    }
}
