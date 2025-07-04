package com.distribuida.principal;

import com.distribuida.entities.Cliente;

public class ClientePrincipal {
    public static void main(String[] args){

        Cliente cliente = new Cliente(1, "1716699515", "Cristian", "Barreno", "av. sebastian", "0984443705", "carl@kk.vom");

        System.out.println(cliente.toString());

    }

}
