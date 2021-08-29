package cn.lianxf.cloud.jpa.config;

import com.alibaba.druid.DbType;
import com.alibaba.druid.pool.xa.DruidXADataSource;
import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.sql.DataSource;
import javax.transaction.UserTransaction;
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

    @Bean(name = "oracleDataSource")
    @Primary
    @Autowired
    public DataSource oracleDataSource(Environment env) {
        AtomikosDataSourceBean ds = new AtomikosDataSourceBean();
        Properties prop = build(env, "spring.datasource.druid.oracle.");
        ds.setXaDataSourceClassName("com.alibaba.druid.pool.xa.DruidXADataSource");
        ds.setUniqueResourceName("oracleDataSource");
        ds.setPoolSize(5);
        ds.setXaProperties(prop);
        return ds;
    }

    @Bean(name = "mysqlDataSource")
    public AtomikosDataSourceBean mysqlDataSource(Environment env) {
        DruidXADataSource source = new DruidXADataSource();
        source.setDbType(DbType.mysql);
        AtomikosDataSourceBean ds = new AtomikosDataSourceBean();
        Properties prop = build(env, "spring.datasource.druid.mysql.");
        ds.setXaDataSourceClassName("com.alibaba.druid.pool.xa.DruidXADataSource");
        ds.setUniqueResourceName("mysqlDataSource");
        ds.setPoolSize(5);

        ds.setXaProperties(prop);
        return ds;
    }


    @Bean(name = "transactionManager")
    public JtaTransactionManager transactionManager () {
        UserTransactionManager userTransactionManager = new UserTransactionManager();
        UserTransaction userTransaction = new UserTransactionImp();
        return new JtaTransactionManager(userTransaction, userTransactionManager);
    }

    private Properties build(Environment env, String prefix) {
        Properties prop = new Properties();
        prop.put("url", env.getProperty(prefix + "url"));
        prop.put("username", env.getProperty(prefix + "username"));
        prop.put("password", env.getProperty(prefix + "password"));
        prop.put("initialSize", env.getProperty(prefix + "initial-size", Integer.class));
        prop.put("minIdle", env.getProperty(prefix + "min-idle", Integer.class));
        prop.put("maxActive", env.getProperty(prefix + "max-active", Integer.class));
        prop.put("maxWait", env.getProperty(prefix + "max-wait", Integer.class));
        prop.put("validationQuery", env.getProperty(prefix + "validation-query"));
        prop.put("validationQueryTimeout", env.getProperty(prefix + "validation-query-timeout", Integer.class));
        prop.put("testWhileIdle", env.getProperty(prefix + "test-while-idle", Boolean.class));
        prop.put("testOnBorrow", env.getProperty(prefix + "test-on-borrow", Boolean.class));
        prop.put("testOnReturn", env.getProperty(prefix + "test-on-return", Boolean.class));
        prop.put("filters", env.getProperty(prefix + "filters"));
        prop.put("connectionProperties", env.getProperty(prefix + "connectionProperties"));
        return prop;
    }
}
