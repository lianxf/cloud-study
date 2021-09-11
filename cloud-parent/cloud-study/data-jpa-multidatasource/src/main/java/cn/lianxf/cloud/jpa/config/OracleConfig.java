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
 * @className OracleConfig
 * @description Oracle DataSource Config
 * @date 2021/8/13 下午10:45
 * @author little
 * @version 1.0.0
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef="oracleEntityManagerFactory",
        transactionManagerRef="oracleTransactionManager",
        basePackages= { "cn.lianxf.cloud.jpa.repository.oracle" })
public class OracleConfig {


    @Autowired
    private JpaProperties jpaPreperties;

    @Value("${spring.jpa.hibernate.oracle-dialect}")
    private String oracleDialect;

    @Autowired
    @Qualifier("oracleDataSource")
    private DataSource dataSource;

    @Primary
    @Bean(name = "oracleEntityManager")
    public EntityManager oracleEntityManager(EntityManagerFactoryBuilder builder) {
        return oracleEntityManagerFactory(builder).getObject().createEntityManager();
    }

    @Primary
    @Bean(name = "oracleEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean oracleEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(dataSource)
                .properties(getVendorProperties())
                // 设置实体类所在位置
                .packages("cn.lianxf.cloud.jpa.cn.lianxf.cloud.entity.oracle")
                .persistenceUnit("oraclePersistenceUnit")
                .build();
    }

    private Map<String, String> getVendorProperties() {
    	// 手动设置命名策略(可选)
        Map<String,String> map=new HashMap<>(2);
        map.put("hibernate.dialect", oracleDialect);
        jpaPreperties.setProperties(map);
        return jpaPreperties.getProperties();
    }

    @Primary
    @Bean(name = "oracleTransactionManager")
    public PlatformTransactionManager oracleTransactionManager(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(oracleEntityManagerFactory(builder).getObject());
    }

}
