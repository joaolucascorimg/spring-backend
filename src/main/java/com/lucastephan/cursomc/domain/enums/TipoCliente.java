package com.lucastephan.cursomc.domain.enums;

public enum TipoCliente {
	
	PESSOAFISICA(1, "Pessoa Fisica"),
	PESSOAJURIDICA(2, "Pessoa Juridica");
	
	private int cod;
	private String desc;
	
	// Constructor
	private TipoCliente(int cod, String desc) {
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
	public static TipoCliente toEnum(Integer cod) {	
		if(cod == null) {
			return null;
		}
		for (TipoCliente tipcli : TipoCliente.values()) {
			if(cod.equals(tipcli.getCod())) {
				return tipcli;
			}
		}
		throw new IllegalArgumentException("Id invalido: " + cod);
	}
	
}
