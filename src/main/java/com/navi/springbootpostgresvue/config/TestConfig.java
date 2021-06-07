package com.navi.springbootpostgresvue.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.navi.springbootpostgresvue.entities.Produto;
import com.navi.springbootpostgresvue.repositories.ProdutoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Produto p1 = new Produto(null, "Produto1", 50.00, "asdfw");
		Produto p2 = new Produto(null, "Produto2", 55.00, "asdas");
		Produto p3 = new Produto(null, "Produto3", 582.00, "asdwq");
		Produto p4 = new Produto(null, "Produto4", 482.99, "asdwq");
		Produto p5 = new Produto(null, "Produto5", 82.20, "asdwq");
		Produto p6 = new Produto(null, "Produto6", 52.10, "asdwq");
		Produto p7 = new Produto(null, "Produto7", 51.02, "asdwq");
		Produto p8 = new Produto(null, "Produto8", 509.50, "asdwq");
		
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8));
	}
	
}
