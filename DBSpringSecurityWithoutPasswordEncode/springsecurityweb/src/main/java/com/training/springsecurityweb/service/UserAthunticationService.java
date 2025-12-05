package com.training.springsecurityweb.service;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.training.springsecurityweb.dao.UserInfo;
import com.training.springsecurityweb.dao.UserRepository;

@Service
public class UserAthunticationService implements UserDetailsService{

	@Autowired
	UserRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserInfo usr = repo.findByUname(username);
		User securedUser = new User(usr.getUname(),"{noop}"+usr.getPassword(),Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
		return securedUser;
	}

}
