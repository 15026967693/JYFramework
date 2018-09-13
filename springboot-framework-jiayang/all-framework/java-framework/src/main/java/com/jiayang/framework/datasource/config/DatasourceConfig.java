package com.jiayang.framework.datasource.config;

import javax.sql.DataSource;
import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class DataSourceConfig {
    @Bean(name="datasource1")
    @ConfigurationProperties(prefix="datasource.datasource1")
    public DataSource datasource1()
    {
        return new DruidDataSource();
    }
}