package com.navi.springbootpostgresvue.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.navi.springbootpostgresvue.entities.Produto;

@RestController
@RequestMapping
public class ProdutoResource {
	
	@GetMapping
	public ResponseEntity<Produto> buscaTodosProdutos(){
		Produto u = new Produto(1L, "Banana", 2.50, "asdas");
		return ResponseEntity.ok().body(u);
	}
}
