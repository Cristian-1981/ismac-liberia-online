package com.distribuida.dao;

import com.distribuida.model.*;
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

public class LibroRepositoryTestIntegracion {

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Test
    public void findAll(){
        List<Libro> libros = libroRepository.findAll();
        assertNotNull(libros);
        assertTrue(libros.size()>0);
        for (Libro item: libros){
            System.out.println(item.toString());
        }
    }

    @Test
    public void findOne(){
        Optional<Libro> libro = libroRepository.findById(72);
        assertNotNull(libro);
        assertEquals("nuevos dictadores",libro.orElse(null).getTitulo());
        System.out.println(libro.toString());
    }

    @Test
    public void save(){
        Optional<Categoria> categoria = categoriaRepository.findById(1);
        assertTrue(categoria.isPresent());
        Optional<Autor> autor = autorRepository.findById(1);
        assertTrue(autor.isPresent());
        Libro libro = new Libro();
        libro.setIdLibro(0);
        libro.setTitulo("Los williams");
        libro.setEditotial("Mallorca");
        libro.setNumpaginas(204);
        libro.setEdicion("Segunda");
        libro.setIdioma("Español");
        libro.setFechapublicacion(new Date());
        libro.setDescripcion("Como empezo Frank Williams en la formula 1");
        libro.setTipopasta("Dura");
        libro.setIsbn("9548585455");
        libro.setNumejemplares(100);
        libro.setPortada("Color Azul");
        libro.setPresentacion("Fisica");
        libro.setPrecio(41.25);
        libro.setIdioma("Español");
        libro.setAutor(autor.orElse(null));
        libro.setCategoria(categoria.orElse(null));
        Libro libroGuardado = libroRepository.save(libro);
        assertNotNull(libroGuardado);
        assertEquals("Los williams", libroGuardado.getTitulo());
        assertEquals(204, libroGuardado.getNumpaginas());
    }

    @Test
    public void update(){
        Optional<Libro> libroExistente = libroRepository.findById(79);
        Optional<Categoria> categoriaExistente = categoriaRepository.findById(2);

        assertNotNull(libroExistente);
        assertNotNull(categoriaExistente);

        libroExistente.orElse(null).setEditotial("Madrid");
        libroExistente.orElse(null).setNumpaginas(150);
        libroExistente.orElse(null).setIdioma("Ingles");
        libroExistente.orElse(null).setCategoria(categoriaExistente.orElse(null));

        Libro libroActualizado = libroRepository.save(libroExistente.orElse(null));

        assertNotNull(libroActualizado);
        assertEquals("Madrid", libroActualizado.getEditotial());
    }

    @Test
    public void delete(){
        if(libroRepository.existsById(79)){
            libroRepository.deleteById(79);
        }
        assertFalse(libroRepository.existsById(79));
    }
}
