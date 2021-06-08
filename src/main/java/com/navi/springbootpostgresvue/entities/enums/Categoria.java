package com.navi.springbootpostgresvue.entities.enums;

public enum Categoria {
	CATEGORIA_1(1),
	CATEGORIA_2(2),
	CATEGORIA_3(3);
	
	private int codigo;
	
	private Categoria(int codigo) {
		this.codigo = codigo;
	}
	
	public int pegarCodigoEnumCategoria() {
		return codigo;
	}
	
	public static Categoria valueOf(int codigo) {
		for (Categoria v1 : Categoria.values()) {
			if (v1.pegarCodigoEnumCategoria() == codigo) {
				return v1;
			}
		}
		throw new IllegalArgumentException("Codigo invalido");
	}
}
