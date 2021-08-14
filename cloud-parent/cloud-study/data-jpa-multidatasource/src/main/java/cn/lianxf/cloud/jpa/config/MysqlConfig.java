package cn.lianxf.cloud.jpa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

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
        entityManagerFactoryRef="mysqlEntityManagerFactory",
        transactionManagerRef="mysqlTransactionManager",
        basePackages= { "cn.lianxf.cloud.jpa.repository.mysql" })
public class MysqlConfig {


    @Autowired
    private JpaProperties jpaPreperties;

    @Value("${spring.jpa.hibernate.mysql-dialect}")
    private String mysqlDialect;

    @Autowired
    @Qualifier("mysqlDataSource")
    private DataSource dataSource;

    @Bean(name = "mysqlEntityManager")
    public EntityManager mysqlEntityManager(EntityManagerFactoryBuilder builder) {
        return mysqlEntityManagerFactory(builder).getObject().createEntityManager();
    }

    @Bean(name = "mysqlEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean mysqlEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(dataSource)
                .properties(getVendorProperties())
                // 设置实体类所在位置
                .packages("cn.lianxf.cloud.jpa.entity.mysql")
                .persistenceUnit("mysqlPersistenceUnit")
                .build();
    }

    private Map<String, String> getVendorProperties() {
    	// 手动设置命名策略(可选)
        Map<String,String> map=new HashMap<>(2);
        map.put("hibernate.dialect", mysqlDialect);
        jpaPreperties.setProperties(map);
        return jpaPreperties.getProperties();
    }

    @Bean(name = "mysqlTransactionManager")
    public PlatformTransactionManager mysqlTransactionManager(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(mysqlEntityManagerFactory(builder).getObject());
    }

}
