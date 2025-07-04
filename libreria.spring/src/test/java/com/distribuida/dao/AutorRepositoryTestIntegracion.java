package com.distribuida.dao;

import com.distribuida.model.Autor;
import com.distribuida.model.Categoria;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@Rollback(value = false)

public class AutorRepositoryTestIntegracion {

    @Autowired
    private AutorRepository autorRepository;

    @Test
    public void findAll(){
        List<Autor> autors = autorRepository.findAll();
        assertNotNull(autors);
        assertTrue(autors.size()>0);
        for(Autor item: autors){
            System.out.println(item.toString());
        }
    }

    @Test
    public void findOne(){
        Optional<Autor> autor = autorRepository.findById(1);
        assertTrue(autor.isPresent());
        System.out.println(autor.toString());
    }

    @Test
    public void save (){
        Autor autor = new Autor(0,"Juan","Neruda","Colombia", "Av. Sebastian", "098565858","juanneruda@gmail.com");
        Autor autorguardado = autorRepository.save(autor);
        assertNotNull(autorguardado);
        assertEquals("Juan",autorguardado.getNombre());
        assertEquals("Neruda",autorguardado.getApellido());
    }

    @Test
    public void update(){
        Optional<Autor> autor = autorRepository.findById(54);
        assertTrue(autor.isPresent(),"El autor con id = 54 deberia existir");
        autor.orElse(null).setPais("España");
        autor.orElse(null).setDireccion("Av. Madrid");

        Autor autorActualizado = autorRepository.save(autor.orElse(null));
        assertNotNull(autorActualizado);
        assertEquals("España", autorActualizado.getPais());
        assertEquals("Av. Madrid", autorActualizado.getDireccion());
    }

    @Test
    public void delete(){
        if(autorRepository.existsById(54)){
            autorRepository.deleteById(54);
        }
        assertFalse(autorRepository.existsById(54),"El id = 58 debia eliminarse");
    }
}
