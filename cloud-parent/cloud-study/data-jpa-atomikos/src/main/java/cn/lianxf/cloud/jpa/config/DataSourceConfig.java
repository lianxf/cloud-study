package cn.lianxf.cloud.jpa.config;

import com.alibaba.druid.pool.xa.DruidXADataSource;
import com.mysql.cj.jdbc.MysqlXADataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
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
        DruidXADataSource druidXADataSource = new DruidXADataSource();
        druidXADataSource.setUrl(properties.getUrl());
        druidXADataSource.setUsername(properties.getUsername());
        druidXADataSource.setPassword(properties.getPassword());
        druidXADataSource.setDefaultAutoCommit(false);
        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        atomikosDataSourceBean.setXaDataSource(druidXADataSource);
        atomikosDataSourceBean.setUniqueResourceName("oracleDataSource");
        atomikosDataSourceBean.setPoolSize(5);
        return atomikosDataSourceBean;
    }

    @Bean("mysqlDataSource")
    public DataSource mysqlDataSource(MysqlProperties properties) throws Exception{
        DruidXADataSource druidXADataSource = new DruidXADataSource();
        druidXADataSource.setUrl(properties.getUrl());
        druidXADataSource.setUsername(properties.getUsername());
        druidXADataSource.setPassword(properties.getPassword());
        druidXADataSource.setDefaultAutoCommit(false);
        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        atomikosDataSourceBean.setXaDataSource(druidXADataSource);
        atomikosDataSourceBean.setUniqueResourceName("mysqlDataSource");
        atomikosDataSourceBean.setPoolSize(5);
        return atomikosDataSourceBean;
    }
}
