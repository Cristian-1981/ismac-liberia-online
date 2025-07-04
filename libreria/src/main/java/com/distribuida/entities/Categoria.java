package com.distribuida.entities;

public class Categoria {
    private int idCategoria;
    private String categorias;
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
