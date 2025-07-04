package com.distribuida.principal;

import com.distribuida.entities.Factura;
import com.distribuida.entities.Facturadetalle;
import com.distribuida.entities.Libro;

import java.util.Date;

public class FacturadetallePrincipal {

    public static void main(String[] args){

        Facturadetalle facturadetalle = new Facturadetalle();

        Factura factura = new Factura();
        factura.setIdFactura(1);
        factura.setNumFactura("fact. 001");
        factura.setFecha(new Date());
        factura.setTotalNeto(100.00);
        factura.setIva(15.00);
        factura.setTotal(115.00);

        Libro libro = new Libro();
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

        facturadetalle.setIdFacturadetalle(1);
        facturadetalle.setCantidad(2);
        facturadetalle.setSubtotal(200.00);

        facturadetalle.setLibro(libro);
        facturadetalle.setFactura(factura);

        System.out.println(facturadetalle.toString());

    }

}
