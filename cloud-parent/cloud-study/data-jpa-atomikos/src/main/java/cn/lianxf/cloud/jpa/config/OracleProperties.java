package cn.lianxf.cloud.jpa.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @className MysqlProperties
 * @description Mysql Properties
 * @date 2021/8/14 下午9:29
 * @author little
 * @version 1.0.0
 */
@Component
@Data
@ConfigurationProperties(prefix = "spring.jta.atomikos.datasource.oracle.xa-properties")
public class OracleProperties {
    private String url;
    private String username;
    private String password;
    private int minPoolSize;
    private int maxPoolSize;
    private int maxLifetime;
    private int borrowConnectionTimeout;
    private int loginTimeout;
    private int maintenanceInterval;
    private int maxIdleTime;
    private String testQuery;
}
