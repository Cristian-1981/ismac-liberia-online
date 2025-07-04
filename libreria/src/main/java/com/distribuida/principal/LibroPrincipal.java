package com.distribuida.principal;

import com.distribuida.entities.Autor;
import com.distribuida.entities.Categoria;
import com.distribuida.entities.Libro;

import java.util.Date;

public class LibroPrincipal {

    public static void main(String[] args){

        Libro libro = new Libro();

        Autor autor = new Autor(1,"Juan", "Neruda", "Mexico", "Av. Galeas", "02245866", "juan@juan.com");
        Categoria categoria = new Categoria(1,"Aventura","Relacionado con la busqueda de tesoros");

        libro.setIdLibro(1);
        libro.setTitulo("El Tesoro de Atahualpa");
        libro.setEditotial("Editorial Luna");
        libro.setNumpaginas(125);
        libro.setEdicion("Primera");
        libro.setIdioma("Español");
        libro.setFechapublicacion(new Date());
        libro.setDescripcion("Trata sobre la busqueda del tesoro que escondio Atahualpa");
        libro.setTipopasta("Simple");
        libro.setIsbn("KLIP");
        libro.setNumejemplares(50);
        libro.setPortada("Dibujada");
        libro.setPresentacion("Full color");
        libro.setPrecio(100.00);

        libro.setAutor(autor);
        libro.setCategoria(categoria);


        System.out.println(libro.toString());

    }


}
