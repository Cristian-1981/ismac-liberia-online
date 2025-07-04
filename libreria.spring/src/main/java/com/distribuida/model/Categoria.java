package com.distribuida.model;

import jakarta.persistence.*;

@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private int idCategoria;
    @Column(name = "categoria")
    private String categorias;
    @Column(name = "descripcion")
    private String descripcion;

    public Categoria() {
    }

    public Categoria(int idCategoria, String categorias, String descripcion) {
        this.idCategoria = idCategoria;
        this.categorias = categorias;
        this.descripcion = descripcion;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCategorias() {
        return categorias;
    }

    public void setCategorias(String categorias) {
        this.categorias = categorias;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "idCategoria=" + idCategoria +
                ", categorias='" + categorias + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }



}
