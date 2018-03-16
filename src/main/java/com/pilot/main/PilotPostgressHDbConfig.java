package com.pilot.main;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "pilotEntityManagerFactory",
						transactionManagerRef = "pilotTransactionManager",
						basePackages = {"com.pilot.main.pilotrepo.repo" })
public class PilotPostgressHDbConfig {

	@Autowired
	Environment env;

	@Primary
	@Bean(name = "pilotDataSource")
	@ConfigurationProperties(prefix = "postgres.datasource")
	public DataSource dataSource() {
		// return DataSourceBuilder.create().build();
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName(env.getProperty("postgres.datasource.driver-class-name"));
	    dataSource.setUrl(env.getProperty("postgres.datasource.url"));
	    dataSource.setUsername(env.getProperty("postgres.datasource.username"));
	    dataSource.setPassword(env.getProperty("postgres.datasource.password"));
	    return dataSource;
	}

	@Primary
	@Bean(name = "pilotEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("pilotDataSource") DataSource pilotDataSource) {
		return builder.dataSource(pilotDataSource).packages("com.pilot.main.pilotrepo.entity")
				.persistenceUnit("FCT_DM_COMPANY_LEVEL_ACTUAL_VS_TARGET")
			.build();
	}

	@Primary
	@Bean(name = "pilotTransactionManager")
	public PlatformTransactionManager transactionManager(
			@Qualifier("pilotEntityManagerFactory") EntityManagerFactory pilotEntityManagerFactory) {
		return new JpaTransactionManager(pilotEntityManagerFactory);
	}
}