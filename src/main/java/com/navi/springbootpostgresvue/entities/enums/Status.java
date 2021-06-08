package com.navi.springbootpostgresvue.entities.enums;

public enum Status {
	SEM_ESTOQUE(1),
	BAIXO_ESTOQUE(2),
	EM_ESTOQUE(3);
	
	private int codigo;
	
	private Status(int codigo) {
		this.codigo = codigo;
	}
	
	public int pegarCodigoEnumStatus() {
		return codigo;
	}
	
	public static Status valueOf(int codigo) {
		for (Status v1 : Status.values()) {
			if (v1.pegarCodigoEnumStatus() == codigo) {
				return v1;
			}
		}
		throw new IllegalArgumentException("Codigo invalido");
	}
}
