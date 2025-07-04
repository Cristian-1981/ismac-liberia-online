package com.distribuida.principal;

import com.distribuida.entities.Autor;

public class AutorPrincipal {

        public static void main(String[] args){

            Autor autor = new Autor(1,"Juan", "Neruda", "Mexico", "Av. Galeas", "02245866", "juan@juan.com");

            System.out.println(autor.toString());
        }


    }
