package com.navi.springbootpostgresvue.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.navi.springbootpostgresvue.entities.enums.Categoria;
import com.navi.springbootpostgresvue.entities.enums.Status;

@Entity
public class Produto implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Double preco;
	@Column(unique = true)
	private String codigo;
	private Integer categoria;
	private Integer status;
	
	public Produto() {
		
	}


	public Produto(Long id, String nome, Double preco, String codigo, Categoria categoria, Status status) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.codigo = codigo;
		setCategoria(categoria);
		setStatus(status);
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Double getPreco() {
		return preco;
	}


	public void setPreco(Double preco) {
		this.preco = preco;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public Categoria getCategoria() {
		return Categoria.valueOf(categoria);
	}


	public void setCategoria(Categoria categoria) {
		if (categoria != null) {
			this.categoria = categoria.pegarCodigoEnumCategoria();
		}
	}


	public Status getStatus() {
		return Status.valueOf(status);
	}


	public void setStatus(Status status) {
		this.status = status.pegarCodigoEnumStatus();
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
