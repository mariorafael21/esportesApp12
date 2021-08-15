package com.example.esportesapp.service;

import com.example.esportesapp.model.Produto;
import com.example.esportesapp.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    ProdutoRepository repository;

    @Autowired
    public void setRepository(ProdutoRepository repository) {
        this.repository = repository;
    }

    public List<Produto> findAll(){
        return repository.findAll();
    }

    public void save(Produto produto){
        repository.save(produto);
    }
    public void delete(Long id){
        repository.deleteById(id);
    }

    public Produto findById(Long id){
        return repository.getById(id);
    }
}
