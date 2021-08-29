package cn.lianxf.cloud.jpa.config;

import org.hibernate.engine.transaction.jta.platform.internal.AtomikosJtaPlatform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * @className MysqlConfig
 * @description Mysql DataSource Config
 * @date 2021/8/13 下午10:45
 * @author little
 * @version 1.0.0
 */
@DependsOn("transactionManager")
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        transactionManagerRef = "transactionManager",
        entityManagerFactoryRef="mysqlEntityManager",
        basePackages= { "cn.lianxf.cloud.jpa.repository.mysql" })
public class MysqlConfig {

    @Autowired
    @Qualifier("mysqlDataSource")
    private DataSource mysqlDataSource;


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

    @Bean(name = "mysqlEntityManager")
    @DependsOn("transactionManager")
    public LocalContainerEntityManagerFactoryBean mysqlEntityManager() throws Throwable {

        HashMap<String, Object> properties = new HashMap<String, Object>();
        properties.put("hibernate.transaction.jta.platform", AtomikosJtaPlatform.class.getName());
        properties.put("javax.persistence.transactionType", "JTA");
        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setJtaDataSource(mysqlDataSource);
        entityManager.setJpaVendorAdapter(mysqlJpaVendorAdapter());
        entityManager.setPackagesToScan("cn.lianxf.cloud.jpa.entity.mysql");
        entityManager.setPersistenceUnitName("mysqlPersistenceUnit");
        entityManager.setJpaPropertyMap(properties);
        return entityManager;
    }

}
