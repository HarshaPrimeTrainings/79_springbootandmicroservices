package com.training.springsecurityweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

	@Bean
	PasswordEncoder encodePassword() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	SecurityFilterChain configSecurityFilter(HttpSecurity httpSecurity) throws Exception {
		
		httpSecurity.authorizeHttpRequests(auth->auth.requestMatchers("/home","/save").permitAll()
				.requestMatchers("/admin").hasAnyRole("ADMIN","MGR") // ROLE_USER ROLE_MGR
				.anyRequest().authenticated())
		.formLogin(formlogin->formlogin.permitAll())
		.logout(logout->logout.permitAll())
		.csrf(csrf->csrf.disable());
		
		return httpSecurity.build();
	}
	
	
}
