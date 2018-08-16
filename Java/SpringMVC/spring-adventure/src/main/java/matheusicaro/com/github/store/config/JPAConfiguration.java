package matheusicaro.com.github.store.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;



@EnableTransactionManagement
public class JPAConfiguration {
	
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory (DataSource dataSource, Properties additionalProperties) {

        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setPackagesToScan("matheusicaro.com.github.store.models");
        factoryBean.setDataSource(dataSource);

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        factoryBean.setJpaVendorAdapter(vendorAdapter);
		
		factoryBean.setJpaProperties(additionalProperties);
        return factoryBean;
    }

	@Bean
	public JpaTransactionManager transectionManager (EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}

//	Config DB MySQL
//    @Bean
//    @Profile("dev")
//    public Properties additionalProperties() {
//    	
//    	Properties props = new Properties();
//    	props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
//    	props.setProperty("hibernate.hbm2ddl.auto", "create-drop");
//    	props.setProperty("hibernate.show_sql", "true");
//    	return props;
//    }
//    
//    @Bean
//    @Profile("dev")
//    public DriverManagerDataSource dataSource() {
//    	
//    	DriverManagerDataSource dataSource = new DriverManagerDataSource();
//    	dataSource.setUsername("root");
//    	dataSource.setPassword("12345");
//    	dataSource.setUrl("jdbc:mysql://localhost/spring_adventure");
//    	dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//    
//    	return dataSource;
//    }

    
//	Config DB PostGre
    @Bean
    @Profile("dev")
    public Properties additionalProperties() {
    	
    	Properties props = new Properties();
    	props.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
    	props.setProperty("hibernate.hbm2ddl.auto", "update"); //create-drop
    	props.setProperty("hibernate.show_sql", "true");
    	return props;
    }
    
    @Bean
    @Profile("dev")
    public DriverManagerDataSource dataSource() {
    	
    	DriverManagerDataSource dataSource = new DriverManagerDataSource();
    	dataSource.setUsername("postgres");
    	dataSource.setPassword("12345");
    	dataSource.setUrl("jdbc:postgresql://localhost:5432/spring-adventure");
    	dataSource.setDriverClassName("org.postgresql.Driver");
    
    	return dataSource;
    }
    
}
