package com.lucastephan.springbackend.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
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
				.setExpiration(new Date(System.currentTimeMillis() + expiration)) // Data atual + tempo de expiracao em milissegundos
				.signWith(SignatureAlgorithm.HS512, secret.getBytes()) // Assinatura escolhendo o algoritimo e transpilacao do segredo de string para bytes
				.compact(); // Compactacao do JWT String
	}

	public boolean tokenValido(String token) {
		Claims claims = getClaims(token);
		if (claims != null) {
			String username = claims.getSubject(); // Funcao do claims para retornar o usuario
			Date expirationDate = claims.getExpiration(); // Funcao do claims para retornar a data de expiracao
			Date now = new Date(System.currentTimeMillis());
			if (username != null && expirationDate != null && now.before(expirationDate))
				return true;
		}
		return false;
	}
	
	public String getUsername(String token ) {
		Claims claims = getClaims(token);
		if (claims != null)
			return claims.getSubject();
		return null;
	}

	// Metodo para obter os Claims a partir de um token
	private Claims getClaims(String token) {
		try {
			return Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token).getBody();
		} catch (Exception e) {
			return null;
		}
	}

}
