package cn.lianxf.cloud.jpa.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
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
    @Bean("oracleDataSource")
    @ConfigurationProperties(prefix = "spring.jta.atomikos.datasource.oracle")
    public DataSource oracleDataSource(){
        return new AtomikosDataSourceBean();
    }

    @Bean("mysqlDataSource")
    @ConfigurationProperties(prefix = "spring.jta.atomikos.datasource.mysql")
    public DataSource mysqlDataSource() throws Exception{
        return new AtomikosDataSourceBean();
    }
}
