package cn.lianxf.cloud.config;

import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.alibaba.druid.wall.WallConfig;
import com.alibaba.druid.wall.WallFilter;
import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.sql.DataSource;
import javax.transaction.UserTransaction;
import java.util.Properties;

/**
 * @className DruidConfig
 * @description Druid Config
 * @date 2021/8/13 上午12:19
 * @author little
 * @version 1.0.0
 */
@Configuration
public class DruidConfig {


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


    @Autowired
    @Bean(name = "mysqlDataSource")
    public AtomikosDataSourceBean mysqlDataSource(Environment env) {
        AtomikosDataSourceBean ds = new AtomikosDataSourceBean();
        Properties prop = build(env, "spring.datasource.druid.mysql.");
        ds.setXaDataSourceClassName("com.alibaba.druid.pool.xa.DruidXADataSource");
        ds.setUniqueResourceName("mysqlDataSource");
        ds.setPoolSize(5);
        ds.setXaProperties(prop);
        return ds;
    }


    @Bean(name = "jtaTransactionManager")
    public JtaTransactionManager jtaTransactionManager () {
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

    @Bean
    public ServletRegistrationBean<StatViewServlet> druidServlet() {
        ServletRegistrationBean<StatViewServlet> servletRegistrationBean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        // 控制台管理用户，加入下面2行 进入druid后台就需要登录
        //servletRegistrationBean.addInitParameter("loginUsername", "admin");
        //servletRegistrationBean.addInitParameter("loginPassword", "admin");
        return servletRegistrationBean;
    }


    @Bean
    public FilterRegistrationBean<WebStatFilter> filterRegistrationBean() {
        FilterRegistrationBean<WebStatFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        filterRegistrationBean.addInitParameter("profileEnable", "true");
        return filterRegistrationBean;
    }

    @Bean
    public StatFilter statFilter(){
        StatFilter statFilter = new StatFilter();
        // slowSqlMillis用来配置SQL慢的标准，执行时间超过slowSqlMillis的就是慢。
        statFilter.setLogSlowSql(true);
        // SQL合并配置
        statFilter.setMergeSql(true);
        // slowSqlMillis的缺省值为3000，也就是3秒。
        statFilter.setSlowSqlMillis(1000);
        return statFilter;
    }

    @Bean
    public WallFilter wallFilter(){
        WallFilter wallFilter = new WallFilter();
        // 允许执行多条SQL
        WallConfig config = new WallConfig();
        config.setMultiStatementAllow(true);
        wallFilter.setConfig(config);
        return wallFilter;
    }

}
