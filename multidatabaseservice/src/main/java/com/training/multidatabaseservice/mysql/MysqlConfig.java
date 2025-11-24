package com.training.multidatabaseservice.mysql;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableJpaRepositories(
		basePackages = "com.training.multidatabaseservice.mysql",
		entityManagerFactoryRef = "mysqlentitymanager",
		transactionManagerRef = "mysqltrnsaction")
public class MysqlConfig {

	@Bean("mysqlentitymanager")
	public LocalContainerEntityManagerFactoryBean h2EntityManager(EntityManagerFactoryBuilder em,@Qualifier("mysqldb") DataSource ds) {
		return em.dataSource(ds).packages("com.training.multidatabaseservice.mysql").persistenceUnit("mysql").build();
	}
	
	@Bean("mysqltrnsaction")
	public PlatformTransactionManager h2transaction(@Qualifier("mysqlentitymanager") EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
	
	
}

