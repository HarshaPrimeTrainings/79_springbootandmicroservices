package com.training.multidatabaseservice.h2;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableJpaRepositories(
		basePackages = "com.training.multidatabaseservice.h2",
		entityManagerFactoryRef = "h2entitymanager",
		transactionManagerRef = "h2trnsaction")
public class H2DbConfig {

	@Primary
	@Bean("h2entitymanager")
	public LocalContainerEntityManagerFactoryBean h2EntityManager(EntityManagerFactoryBuilder em,@Qualifier("h2db") DataSource ds) {
		return em.dataSource(ds).packages("com.training.multidatabaseservice.h2").persistenceUnit("h2").build();
	}
	
	@Primary
	@Bean("h2trnsaction")
	public PlatformTransactionManager h2transaction(@Qualifier("h2entitymanager") EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
	
	
}

