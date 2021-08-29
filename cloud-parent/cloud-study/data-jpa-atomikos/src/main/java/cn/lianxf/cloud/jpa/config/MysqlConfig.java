package cn.lianxf.cloud.jpa.config;

import com.mysql.cj.jdbc.MysqlXADataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @className MysqlConfig
 * @description Mysql DataSource Config
 * @date 2021/8/13 下午10:45
 * @author little
 * @version 1.0.0
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        transactionManagerRef = "transactionManager",
        entityManagerFactoryRef = "mysqlEntityManager",
        basePackages= { "cn.lianxf.cloud.jpa.repository.mysql" })
public class MysqlConfig {


    public JpaVendorAdapter mysqlJpaVendorAdapter() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        // 显示sql
        hibernateJpaVendorAdapter.setShowSql(true);
        // 自动生成/更新表
        hibernateJpaVendorAdapter.setGenerateDdl(true);
        // 设置数据库类型
        hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
        return hibernateJpaVendorAdapter;
    }

    /**
     * Oracle 数据源配置
     */
    @Bean(name = "mysqlDataSourceProperties")
    @Qualifier("mysqlDataSourceProperties")
    @ConfigurationProperties(prefix = "spring.datasource.mysql")
    public DataSourceProperties mysqlDataSourceProperties() {
        return new DataSourceProperties();
    }


    @Bean(name = "mysqlDataSource", initMethod = "init", destroyMethod = "close")
    @ConfigurationProperties(prefix = "spring.datasource.mysql")
    public DataSource mysqlDataSource() throws SQLException {
        MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
        mysqlXaDataSource.setUrl(mysqlDataSourceProperties().getUrl());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXaDataSource.setPassword(mysqlDataSourceProperties().getPassword());
        mysqlXaDataSource.setUser(mysqlDataSourceProperties().getUsername());
        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXaDataSource);
        xaDataSource.setUniqueResourceName("mysqlDataSource");
        xaDataSource.setBorrowConnectionTimeout(60);
        xaDataSource.setMaxPoolSize(20);
        return xaDataSource;

    }

    @Bean(name = "mysqlEntityManager")
    @DependsOn("transactionManager")
    public LocalContainerEntityManagerFactoryBean mysqlEntityManager() throws Throwable {

        HashMap<String, Object> properties = new HashMap<String, Object>();
        properties.put("hibernate.transaction.jta.platform", AtomikosJtaPlatform.class.getName());
        properties.put("javax.persistence.transactionType", "JTA");
        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setJtaDataSource(mysqlDataSource());
        entityManager.setJpaVendorAdapter(mysqlJpaVendorAdapter());
        entityManager.setPackagesToScan("cn.lianxf.cloud.jpa.entity.mysql");
        entityManager.setPersistenceUnitName("mysqlPersistenceUnit");
        entityManager.setJpaPropertyMap(properties);
        return entityManager;
    }

}
