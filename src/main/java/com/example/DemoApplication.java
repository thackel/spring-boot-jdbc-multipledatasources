package com.example;

import javax.sql.DataSource;

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

	@Primary
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource primaryDataSource(DataSourceProperties properties) {
		return properties.initializeDataSourceBuilder().build();
	}

	@Bean("second")
	@ConfigurationProperties(prefix = "second")
	public DataSource secondaryDataSource(DataSourceProperties properties) {
		return properties.initializeDataSourceBuilder().build();
	}
}
