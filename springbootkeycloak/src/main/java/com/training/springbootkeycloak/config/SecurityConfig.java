package com.training.springbootkeycloak.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Autowired
	JwtConvertor jwtconvertor;
	
	@Bean
	SecurityFilterChain configSecurityFilter(HttpSecurity httpSecurity) throws Exception {
		
		httpSecurity.authorizeHttpRequests(auth->auth.requestMatchers("/home","/save").permitAll()
				.requestMatchers("/admin/**").hasAnyAuthority("admin") 
				.anyRequest().authenticated())
		.oauth2ResourceServer(oauth->oauth.jwt(jwt->jwt.jwtAuthenticationConverter(jwtconvertor)))
		.logout(logout->logout.permitAll())
		.csrf(csrf->csrf.disable());
		
		return httpSecurity.build();
	}
}
