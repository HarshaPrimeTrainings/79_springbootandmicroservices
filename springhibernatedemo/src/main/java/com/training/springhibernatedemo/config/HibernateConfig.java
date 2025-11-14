package com.training.springhibernatedemo.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class HibernateConfig {

	@Bean
	public SessionFactory initSession() {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		 Metadata metadata = new MetadataSources(ssr).getMetadataBuilder().build();
		 SessionFactory session= metadata.getSessionFactoryBuilder().build();
		 return session;
		 
	}
	
}
