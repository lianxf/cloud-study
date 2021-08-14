package cn.lianxf.cloud.jpa.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @className DataSourceConfig
 * @description DbConfig
 * @date 2021/8/14 下午7:52
 * @author little
 * @version 1.0.0
 */
@Configuration
public class DataSourceConfig {

    @Primary
    @Bean(name = "oracleDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.druid.oracle")
    public DataSource oracleDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "mysqlDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.druid.mysql")
    public DataSource mysqlDataSource() {
        return DataSourceBuilder.create().build();
    }
}
