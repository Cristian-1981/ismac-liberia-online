package com.distribuida.service;

import com.distribuida.model.Categoria;

import java.util.List;

public interface CategoriaService {

    public List<Categoria> findAll();

    public Categoria findOne(int id);

    public Categoria save(Categoria categoria);

    public Categoria update(int id, Categoria categoria);

    public void delete(int id);

}
