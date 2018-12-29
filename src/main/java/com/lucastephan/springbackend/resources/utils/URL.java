package com.lucastephan.springbackend.resources.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public class URL {

	// Metodo para decodificar strings passadas por parametro que contenham
	// caracteres especiais (conversao para UTF-8)
	public static String decodeParam(String string) {
		try {
			return URLDecoder.decode(string, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}

	// Metodo de conversao de uma string de numeros separados por virgula em uma
	// lista de inteiros
	public static List<Integer> decodeIntList(String string) {
		String[] vet = string.split(",");
		List<Integer> lista = new ArrayList<>();
		for (int i = 0; i < vet.length; i++) {
			lista.add(Integer.parseInt(vet[i]));
		}
		return lista;
	}

}
