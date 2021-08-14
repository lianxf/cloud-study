package cn.lianxf.cloud.config;

import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.Properties;

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
    public DataSource oracleDataSource(OracleProperties properties){
        AtomikosDataSourceBean ds = new AtomikosDataSourceBean();
        ds.setUniqueResourceName("oracleDataSource");
        ds.setXaDataSourceClassName("oracle.jdbc.xa.client.OracleXADataSource");
        Properties p = new Properties();
        p.setProperty("user" , properties.getUsername() );
        p.setProperty("password" , properties.getPassword() );
        p.setProperty("URL" , properties.getUrl());
        ds.setXaProperties(p);
        return ds;
    }

    @Bean("mysqlDataSource")
    public DataSource mysqlDataSource(MysqlProperties properties) throws Exception{
        AtomikosDataSourceBean ds = new AtomikosDataSourceBean();
        ds.setUniqueResourceName("mysqlDataSource");
        ds.setXaDataSourceClassName("com.mysql.cj.jdbc.MysqlXADataSource");
        Properties p = new Properties();
        p.setProperty("user" , properties.getUsername() );
        p.setProperty("password" , properties.getPassword() );
        p.setProperty("URL" , properties.getUrl());
        ds.setXaProperties(p);
        return ds;

    }
}
