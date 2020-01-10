package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

@Component
public class MasterService
{


   /* @Autowired
    @Lazy
    @Qualifier("example1")
    private DataSource dataSource1;

    @Autowired
    @Lazy
    @Qualifier("example2")
    private DataSource dataSource2;
*/
    /*
    @Autowired
    @Qualifier("dbExample3")
    private DataSource dataSource3;*/

    public  Map<Object, Object> getDataSourceHashMap()
    {
       /* DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/db_example1");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        DriverManagerDataSource dataSource1 = new DriverManagerDataSource();
        dataSource1.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource1.setUrl("jdbc:mysql://localhost:3306/db_example2");
        dataSource1.setUsername("root");
        dataSource1.setPassword("root");
*/


      /*  HashMap hashMap = new HashMap();
        hashMap.put("tenantId1", dataSource);
        hashMap.put("tenantId2", dataSource);*/


        HashMap hashMap = new HashMap();
        /*hashMap.put("tenantId1", dataSource1);
        hashMap.put("tenantId2", dataSource2);*/

        return hashMap;
    }

}