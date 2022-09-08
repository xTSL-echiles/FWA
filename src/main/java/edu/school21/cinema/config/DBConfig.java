package edu.school21.cinema.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;


@Configuration
@ComponentScan("edu.school21.cinema")
@PropertySource("file:src/main/webapp/WEB-INF/application.properties")
public class DBConfig {

    @Autowired
    Environment environment;

    private final String URL = "spring.datasource.url";
    private final String USER = "spring.datasource.username";
    private final String DRIVER = "spring.datasource.driver.name";
    private final String PASSWORD = "spring.datasource.password";

    @Bean
    public JdbcTemplate jdbcTemplate() { // через этот класс кидаются запросы в БД
        return new JdbcTemplate(dataSource());
    }

    @Bean
    DataSource dataSource() { // подключение к базе
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl(environment.getProperty(URL));
        driverManagerDataSource.setUsername(environment.getProperty(USER));
        driverManagerDataSource.setPassword(environment.getProperty(PASSWORD));
        driverManagerDataSource.setDriverClassName(environment.getProperty(DRIVER));
        return driverManagerDataSource;
    }
}
