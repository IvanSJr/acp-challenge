package com.navi.springbootpostgresvue.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.navi.springbootpostgresvue.entities.Produto;
import com.navi.springbootpostgresvue.entities.enums.Categoria;
import com.navi.springbootpostgresvue.entities.enums.Status;
import com.navi.springbootpostgresvue.repositories.ProdutoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Produto p1 = new Produto(null, "Produto1", 50.00, "asdfw", Categoria.CATEGORIA_1, Status.EM_ESTOQUE);
		Produto p2 = new Produto(null, "Produto2", 55.80, "assdas", Categoria.CATEGORIA_2, Status.EM_ESTOQUE);
		Produto p3 = new Produto(null, "Produto3", 55.00, "aszzs", Categoria.CATEGORIA_3, Status.BAIXO_ESTOQUE);
		Produto p4 = new Produto(null, "Produto4", 582.00, "escwz", Categoria.CATEGORIA_3, Status.SEM_ESTOQUE);
		Produto p5 = new Produto(null, "Produto5", 482.99, "qsdwq", Categoria.CATEGORIA_2, Status.EM_ESTOQUE);
		Produto p6 = new Produto(null, "Produto6", 82.20, "wsdwq", Categoria.CATEGORIA_1, Status.SEM_ESTOQUE);
		Produto p7 = new Produto(null, "Produto7", 52.10, "dsdwq", Categoria.CATEGORIA_1, Status.BAIXO_ESTOQUE);
		Produto p8 = new Produto(null, "Produto8", 51.02, "csqdwq", Categoria.CATEGORIA_1, Status.EM_ESTOQUE);
		Produto p9 = new Produto(null, "Produto9", 509.50, "bsdwq", Categoria.CATEGORIA_2, Status.SEM_ESTOQUE);
		
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9));
	}
	
}
