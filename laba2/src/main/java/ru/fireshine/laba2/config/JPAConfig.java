package ru.fireshine.laba2.config;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
 
@Configuration
@EnableJpaRepositories(basePackages = {"ru.fireshine.laba2.dao"})
@EnableTransactionManagement
public class JPAConfig {
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
    	LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setPersistenceUnitName("Laba2");
          
        return factoryBean;
    }
      
    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
          
        return transactionManager;
    } 
}