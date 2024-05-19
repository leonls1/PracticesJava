package Testing_DB.demo;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class configuracion {

    @Bean
    public DataSource getDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        
        dataSource.setUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUsername("Leon");
        dataSource.setPassword("yoProgramo");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
                 // dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        
        return dataSource;
        
    }
}
