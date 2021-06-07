package com.navi.springbootpostgresvue.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.navi.springbootpostgresvue.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
