package com.navi.springbootpostgresvue.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import com.navi.springbootpostgresvue.entities.Produto;
import com.navi.springbootpostgresvue.repositories.ProdutoRepository;
import com.navi.springbootpostgresvue.services.exceptions.ResourceNotFoundException;

@Component
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<Produto> buscarTodos(){
		return produtoRepository.findAll();
	}
	
	public Produto buscarPorId(Long id) {
		Optional<Produto> obj = produtoRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Produto inserir(Produto obj) {
		return produtoRepository.save(obj);
	}
	
	public void deletarPorId(Long id) {
		try {
		produtoRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	public void deletarTodos() {
		produtoRepository.deleteAll();
	}
	
	/*public void deletarPorIdSelecionado(List<Long> lista) {
		produtoRepository.deleteAllById(lista);
	}*/
	
	public Produto atualizar(Long id, Produto obj) {
		try {
			Produto entidade = produtoRepository.getById(id);
			atualizarDados(entidade, obj);
			return produtoRepository.save(entidade);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}

	}

	private void atualizarDados(Produto entidade, Produto obj) {
		entidade.setNome(obj.getNome());
		entidade.setPreco(obj.getPreco());
		entidade.setCodigo(obj.getCodigo());
		entidade.setCategoria(obj.getCategoria());
		entidade.setStatus(obj.getStatus());
	}
	

}
