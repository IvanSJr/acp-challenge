package com.navi.springbootpostgresvue.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.navi.springbootpostgresvue.entities.Produto;
import com.navi.springbootpostgresvue.services.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoResource {
	
	@Autowired
	private ProdutoService service;
	
	@GetMapping
	public ResponseEntity<List<Produto>> buscaTodosProdutos(){
		List<Produto> listaProdutos = service.buscarTodos();
		return ResponseEntity.ok().body(listaProdutos);
	}
	
	@GetMapping(value = "/produto/{id}")
	public ResponseEntity<Produto> buscarProdutoPorId(@PathVariable Long id){
		Produto obj = service.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Produto> inserirProduto(@RequestBody Produto obj){
		obj = service.inserir(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/produto/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping("/produto/{id}")
	public ResponseEntity<Void> deletarProduto(@PathVariable Long id){
		service.deletarPorId(id);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping
	public ResponseEntity<Void> deletarTodosProdutos(){
		service.deletarTodos();
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/produto/{id}")
	public ResponseEntity<Produto> atualizarProduto(@PathVariable Long id, @RequestBody Produto obj){
		obj = service.atualizar(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
