package com.example.spring.repository;

import com.example.spring.entity.ProdutoEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<ProdutoEntity, Integer> {
}
