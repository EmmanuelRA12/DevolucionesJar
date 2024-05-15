package com.eglobal.ti.devoluciones.jar.config;

import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
//@PropertySource("file:C:/Users/era7216/Documents/jboss-eap-7.1/standalone/configuration/devoluciones-config.properties")

@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.eglobal.ti.devoluciones.repository", entityManagerFactoryRef = "adqBrEntityManager", transactionManagerRef = "adqBrTransactionManager"

)
public class PersistenceConfig {

	@Value("${init-db:false}")
	private String initDatabase;

	@Primary
	@Bean(name = "adqBrDataSource")
	@ConfigurationProperties(prefix = "sqlserveradqbr.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Primary
	@Bean(name = "jdbcTemplateBr")
	public JdbcTemplate jdbcTemplate(@Qualifier("adqBrDataSource") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

//	@Primary
//	@Bean(name = "adqBrEntityManager")
//	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
//			@Qualifier("adqBrDataSource") DataSource adqBrDataSource) {
//		return builder.dataSource(adqBrDataSource).packages("com.eglobal.ti.devoluciones")
//				.persistenceUnit("sqlserveradqbr").build();
//	}
//
//	@Primary
//	@Bean(name = "adqBrTransactionManager")
//	public PlatformTransactionManager adqBrTransactionManager(
//			@Qualifier("adqBrEntityManager") EntityManagerFactory adqBrEntityManagerFactory) {
//		return new JpaTransactionManager(adqBrEntityManagerFactory);
//	}
}