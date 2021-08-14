package cn.lianxf.cloud.config;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @className OracleConfig
 * @description Oracle数据源配置
 * @date 2021/8/11 下午11:18
 * @author little
 * @version 1.0.0
 */
@MapperScan(basePackages = "cn.lianxf.cloud.mapper.oracle", sqlSessionTemplateRef = "oracleSqlSessionTemplate")
@Configuration
public class OracleConfig {

    @Primary
    @Bean("oracleDatasource")
    @ConfigurationProperties(prefix = "spring.datasource.druid.oracle")
    public DataSource oracleDatasource(){
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean("oracleSqlSessionFactory")
    public SqlSessionFactory oracleSqlSessionFactory(@Qualifier("oracleDatasource") DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        // mapper的xml形式文件位置必须要配置，不然将报错：no statement （这种错误也可能是mapper的xml中，namespace与项目的路径不一致导致）
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/oracle/*.xml"));
        return bean.getObject();
    }

    @Primary
    @Bean("oracleSqlSessionTemplate")
    public SqlSessionTemplate oracleSqlSessionTemplate(@Qualifier("oracleSqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
