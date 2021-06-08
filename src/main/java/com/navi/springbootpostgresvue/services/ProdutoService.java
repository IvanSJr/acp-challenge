package com.navi.springbootpostgresvue.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.navi.springbootpostgresvue.entities.Produto;
import com.navi.springbootpostgresvue.repositories.ProdutoRepository;

@Component
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<Produto> buscarTodos(){
		return produtoRepository.findAll();
	}
	
	public Produto buscarPorId(Long id) {
		Optional<Produto> obj = produtoRepository.findById(id);
		return obj.get();
	}
	
	public Produto inserir(Produto obj) {
		return produtoRepository.save(obj);
	}
	
	public void deletarPorId(Long id) {
		produtoRepository.deleteById(id);
	}
	
	public void deletarPorIdSelecionado(List<Long> lista) {
		produtoRepository.deleteAllById(lista);
	}
	
	public void deletarTodos() {
		produtoRepository.deleteAll();
	}
}
