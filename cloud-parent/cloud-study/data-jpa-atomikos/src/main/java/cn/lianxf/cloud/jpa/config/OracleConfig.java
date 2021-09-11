package cn.lianxf.cloud.jpa.config;

import oracle.jdbc.xa.client.OracleXADataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * @className OracleConfig
 * @description Oracle DataSource Config
 * @date 2021/8/13 下午10:45
 * @author little
 * @version 1.0.0
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        transactionManagerRef = "transactionManager",
        entityManagerFactoryRef = "oracleEntityManager",
        basePackages= { "cn.lianxf.cloud.jpa.repository.oracle" })
public class OracleConfig {


    public JpaVendorAdapter oracleJpaVendorAdapter() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        // 显示sql
        hibernateJpaVendorAdapter.setShowSql(true);
        // 自动生成/更新表
        hibernateJpaVendorAdapter.setGenerateDdl(true);
        // 设置数据库类型
        hibernateJpaVendorAdapter.setDatabase(Database.ORACLE);
        return hibernateJpaVendorAdapter;
    }

    /**
     * Oracle 数据源配置
     */
    @Primary
    @Bean(name = "oracleDataSourceProperties")
    @Qualifier("oracleDataSourceProperties")
    @ConfigurationProperties(prefix = "spring.datasource.oracle")
    public DataSourceProperties oracleDataSourceProperties() {
        return new DataSourceProperties();
    }


    @Primary
    @Bean(name = "oracleDataSource", initMethod = "init", destroyMethod = "close")
    @ConfigurationProperties(prefix = "spring.datasource.oracle")
    public DataSource oracleDataSource() throws SQLException {
        OracleXADataSource oracleXaDataSource = new OracleXADataSource();
        oracleXaDataSource.setURL(oracleDataSourceProperties().getUrl());
        oracleXaDataSource.setPassword(oracleDataSourceProperties().getPassword());
        oracleXaDataSource.setUser(oracleDataSourceProperties().getUsername());
        oracleXaDataSource.setNativeXA(true);
        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(oracleXaDataSource);
        xaDataSource.setUniqueResourceName("oracleDataSource");
        xaDataSource.setBorrowConnectionTimeout(60);
        xaDataSource.setMaxPoolSize(20);
        return xaDataSource;

    }

    @Primary
    @Bean(name = "oracleEntityManager")
    @DependsOn("transactionManager")
    public LocalContainerEntityManagerFactoryBean oracleEntityManager() throws Throwable {

        HashMap<String, Object> properties = new HashMap<String, Object>();
        properties.put("hibernate.transaction.jta.platform", AtomikosJtaPlatform.class.getName());
        properties.put("javax.persistence.transactionType", "JTA");
        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setJtaDataSource(oracleDataSource());
        entityManager.setJpaVendorAdapter(oracleJpaVendorAdapter());
        entityManager.setPackagesToScan("cn.lianxf.cloud.jpa.cn.lianxf.cloud.entity.oracle");
        entityManager.setPersistenceUnitName("oraclePersistenceUnit");
        entityManager.setJpaPropertyMap(properties);
        return entityManager;
    }


}
