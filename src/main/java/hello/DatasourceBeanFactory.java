package hello;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;


@Configuration
public class DatasourceBeanFactory
{

    /*@Autowired
    private Environment env;

    @Bean(name= "example1")
//    @Primary
    @ConfigurationProperties(prefix = "spring.example1.datasource")
    public DataSource primaryDataSource() {
       *//* DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(env.getProperty("example1.datasource.url"));
        dataSource.setUsername(env.getProperty("example1.datasource.username"));
        dataSource.setPassword(env.getProperty("example1.datasource.password"));

        return dataSource;*//*

        return DataSourceBuilder.create().build();
    }





    @Bean(name= "example2")
//    @Primary
    @ConfigurationProperties(prefix = "spring.example2.datasource")
    public DataSource secondDataSource() {
        return DataSourceBuilder.create().build();
    }*/

}
