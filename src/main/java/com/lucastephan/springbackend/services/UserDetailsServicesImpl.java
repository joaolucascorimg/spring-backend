package com.lucastephan.springbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lucastephan.springbackend.domain.Cliente;
import com.lucastephan.springbackend.repositories.ClienteRepository;
import com.lucastephan.springbackend.security.UserSS;

@Service
public class UserDetailsServicesImpl implements UserDetailsService {

	@Autowired
	private ClienteRepository repo;

	@Override // Busca do usuario do SpringSecurity atraves do Email
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Cliente cli = repo.findByEmail(email);
		if (cli == null) {
			throw new UsernameNotFoundException(email);
		}
		return new UserSS(cli.getId(), cli.getEmail(), cli.getSenha(), cli.getPerfis());
	}

}
