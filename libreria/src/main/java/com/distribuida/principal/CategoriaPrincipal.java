package com.distribuida.principal;

import com.distribuida.entities.Categoria;

public class CategoriaPrincipal {

    public static void main(String[] args){

        Categoria categorias = new Categoria(1,"Aventura","Relacionado con la busqueda de tesoros");

        System.out.println(categorias.toString());
    }

}
