package com.jiayang.framework.datasource.config;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef="entityManagerFactoryForDatasource1",
        transactionManagerRef="transactionManagerForDatasource1",
        basePackages={"com.jiayang.framework.repository"}) //设置Repository所在位置
class DatasourceApply {
    @Autowired
    @Qualifier("datasource1")
    private  DataSource datasource1;
    @Autowired
    private  JpaProperties jpaProperties;
    private Map getVendorProperties() {
        return jpaProperties.getHibernateProperties(new HibernateSettings());
    }
    @Bean(name = "entityManagerFactoryForDatasource1")
    public  LocalContainerEntityManagerFactoryBean entityManagerFactoryForDatasource1 (EntityManagerFactoryBuilder builder)
    {
      return   builder
                .dataSource(datasource1)
                .properties(getVendorProperties())
                .packages("com.jiayang.framework.domain") //设置实体类所在位置
                .persistenceUnit("primaryPersistenceUnit")//标识数据源的名字两个以上这个名字必须不同
                .build();
    }
    @Bean(name = "entityManagerForDatasource1")
    public  EntityManager entityManagerForDatasource1(EntityManagerFactoryBuilder builder)
    {
      return   entityManagerFactoryForDatasource1(builder).getObject().createEntityManager();
    }
    @Bean(name = "transactionManagerForDatasource1")
    public PlatformTransactionManager transactionManagerSecondary(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryForDatasource1(builder).getObject());
    }
}