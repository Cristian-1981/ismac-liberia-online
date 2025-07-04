package com.distribuida.dao;

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

public class CategoriaRepositoryTestIntegracion {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Test
    public void findAll(){
        List<Categoria> categorias = categoriaRepository.findAll();
        assertNotNull(categorias);
        assertTrue(categorias.size()>0);
        for(Categoria item: categorias){
            System.out.println(item.toString());
        }
    }
    @Test
    public void findOne(){
        Optional<Categoria> categoria = categoriaRepository.findById(1);
        assertTrue(categoria.isPresent());
        System.out.println(categoria.toString());
    }

    @Test
    public void save (){
        Categoria categoria = new Categoria(0,"Aventura","Busqueda de tesoros");
        Categoria categoriaguardado = categoriaRepository.save(categoria);
        assertNotNull(categoriaguardado);
        assertEquals("Aventura",categoriaguardado.getCategorias());
        assertEquals("Busqueda de tesoros",categoriaguardado.getDescripcion());
    }

    @Test
    public void update(){
        Optional<Categoria> categoria = categoriaRepository.findById(58);
        assertTrue(categoria.isPresent(),"La categoria con id = 58 deberia existir");
        categoria.orElse(null).setCategorias("Infantil");
        categoria.orElse(null).setDescripcion("Aprendizaje");

        Categoria categoriaActualizado = categoriaRepository.save(categoria.orElse(null));
        assertNotNull(categoriaActualizado);
        assertEquals("Infantil", categoriaActualizado.getCategorias());
        assertEquals("Aprendizaje", categoriaActualizado.getDescripcion());
    }

    @Test
    public void delete(){
        if(categoriaRepository.existsById(58)){
            categoriaRepository.deleteById(58);
        }
        assertFalse(categoriaRepository.existsById(58),"El id = 58 debia eliminarse");
    }
}
