package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import javax.sql.DataSource;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private MasterService masterService;

    /*@Bean
    public DataSource dataSource(){
        CustomRoutingDataSource customDataSource = new CustomRoutingDataSource();
        customDataSource.setTargetDataSources(masterService.getDataSourceHashMap());
        return customDataSource;
    }*/

    /*
    volumes:
        - "./conf.d:/etc/mysql/conf.d:ro" */
}
