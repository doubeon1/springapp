package cz.doubeon.cars.config;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

@Configuration
public class DatabaseConfig  {

	/**
	 * Reference to JNDI resource defined in context.xml
	 * @return
	 */
	@Bean
	@Resource(name = "jdbc/carsdb")
	public DataSource dataSourceLookup() {
		final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
		dsLookup.setResourceRef(true);
		final DataSource dataSource = dsLookup.getDataSource("jdbc/carsdb");
		return dataSource;
	}


	// @Bean
	// public JdbcTemplate createJdbcTeamplate() {
	//
	// final JdbcTemplate template = new JdbcTemplate();
	// template.setDataSource(dataSourceLookup());
	//
	// return template;
	// }
}