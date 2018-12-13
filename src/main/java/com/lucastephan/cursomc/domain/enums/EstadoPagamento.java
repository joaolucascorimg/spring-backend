package com.lucastephan.cursomc.domain.enums;

public enum EstadoPagamento {

	PENDENTE(1, "Pendente"),
	QUITADO(2, "Quitado"),
	CANCELADO(3, "Cancelado");
	
	private int cod;
	private String desc;
	
	// Constructor
	private EstadoPagamento(int cod, String desc) {
		this.cod = cod;
		this.desc = desc;
	}
	
	// Getters
	public int getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return desc;
	}
	
	// Metodo de busca
	public static EstadoPagamento toEnum(Integer cod) {	
		if(cod == null) {
			return null;
		}
		for (EstadoPagamento x : EstadoPagamento.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id invalido: " + cod);
	}
	
}
