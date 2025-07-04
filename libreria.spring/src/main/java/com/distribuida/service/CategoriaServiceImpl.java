package com.distribuida.service;

import com.distribuida.dao.CategoriaRepository;
import com.distribuida.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria findOne(int id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        return categoria.orElse(null);
    }

    @Override
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria update(int id, Categoria categoria) {
        Categoria categoriaExistente = findOne(id);

        if(categoriaExistente == null){
            return null;
        }
        categoriaExistente.setCategorias(categoria.getCategorias());
        categoriaExistente.setDescripcion(categoria.getDescripcion());

        return categoriaRepository.save(categoriaExistente);

    }

    @Override
    public void delete(int id) {
        if (categoriaRepository.existsById(id)){
            categoriaRepository.deleteById(id);
        }
    }
}
