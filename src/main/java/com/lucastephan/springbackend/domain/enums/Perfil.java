package com.lucastephan.springbackend.domain.enums;

public enum Perfil {

	// Padrao imposto pelo SpringSecurity (ROLE_XXXXX)
	ADMIN(1, "ROLE_ADMIN"), CLIENTE(2, "ROLE_CLIENTE");

	private int cod;
	private String desc;

	// Constructor
	private Perfil(int cod, String desc) {
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
	public static Perfil toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (Perfil x : Perfil.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id invalido: " + cod);
	}

}
