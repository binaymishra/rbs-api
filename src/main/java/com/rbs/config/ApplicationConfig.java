package com.rbs.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

/**
 * @author Binay Mishra
 *
 */
@Configuration
@ComponentScan(basePackages = {"com.rbs.repository", "com.rbs.manager"})
public class ApplicationConfig {

	/**
	 * @return
	 */
	@Bean
	public DataSource hsqldbDatacource(){
	    return new EmbeddedDatabaseBuilder()
	    .setType(EmbeddedDatabaseType.HSQL)
	    .addScript("classpath:schema.sql")
	    .addScript("classpath:data.sql")
	    .build();
	  }
}
