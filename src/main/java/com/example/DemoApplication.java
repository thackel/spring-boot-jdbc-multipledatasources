package com.example;

import com.zaxxer.hikari.HikariDataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	@Primary
	@ConfigurationProperties("first")
	public DataSourceProperties primaryDataSourceProperties() {
		return new DataSourceProperties();
	}

	@Primary
	@Bean
	@ConfigurationProperties(prefix = "first")
	public HikariDataSource primaryDataSource() {
		return (HikariDataSource) primaryDataSourceProperties().initializeDataSourceBuilder()
				.type(HikariDataSource.class).build();
	}

	@Bean
	@ConfigurationProperties("second")
	public DataSourceProperties secondaryDataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean("second")
	@ConfigurationProperties(prefix = "second")
	public HikariDataSource secondaryDataSource() {
		return (HikariDataSource) secondaryDataSourceProperties().initializeDataSourceBuilder()
				.type(HikariDataSource.class).build();
	}
}
