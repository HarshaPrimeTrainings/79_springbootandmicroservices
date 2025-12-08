package com.training.springsecurityweb.service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
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
		
		Set<GrantedAuthority> authorities = new HashSet<>();
		
		usr.getRoles().stream().forEach(role->{
			authorities.add(()->role.getRole().name());
		});
		
		User securedUser = new User(usr.getUname(),usr.getPassword(),authorities);
		return securedUser;
	}

}
