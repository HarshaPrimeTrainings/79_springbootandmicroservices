package com.training.multidatabaseservice.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DataSourceConfig {

	@Primary
	@Bean("h2db")
	@ConfigurationProperties(prefix = "spring.primary.datasource")
	public DataSource h2datasource() {
		return DataSourceBuilder.create().build();
	}
	
	
	@Bean(name="mysqldb")
	@ConfigurationProperties(prefix = "spring.second.datasource")
	public DataSource mySqldatasource() {
		return DataSourceBuilder.create().build();
	}
	
}
