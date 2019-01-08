package com.lucastephan.springbackend.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtil {

	@Value("${jwt.secret}")
	private String secret;

	@Value("${jwt.expiration}")
	private long expiration;

	// Metodo gerador do JWT Token
	public String generateToken(String email) {
		return Jwts.builder().setSubject(email) // Pega o username
				.setExpiration(new Date(System.currentTimeMillis() + expiration)) // Data atual + tempo de expiracao em
																					// milissegundos
				.signWith(SignatureAlgorithm.HS512, secret.getBytes()) // Assinatura escolhendo o algoritimo e
																		// transpilacao do segredo de string para bytes
				.compact(); // Compactacao do JWT String
	}

}
