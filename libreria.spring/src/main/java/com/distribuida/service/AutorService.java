package com.distribuida.service;

import com.distribuida.model.Autor;

import java.util.List;

public interface AutorService {

    public List<Autor> findAll();

    public Autor findOne(int id);

    public Autor save(Autor autor);

    public Autor update(int id, Autor autor);

    public void delete(int id);
}
