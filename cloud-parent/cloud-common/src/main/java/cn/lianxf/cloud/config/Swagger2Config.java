package cn.lianxf.cloud.config;

import cn.lianxf.cloud.constant.PathConsts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @className Swagger2Config
 * @description Swagger 配置
 * @date 2021/8/7 上午10:26
 * @author little
 * @version 1.0.0
 */
@Slf4j
@EnableSwagger2
@Configuration
public class Swagger2Config {

    @Value("${spring.application.name}")
    private String applicationName;

    @Bean
    public Docket createRestApi() {
        log.info("---------------common swagger--------------");
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("cloud-common")
                .pathMapping(PathConsts.ROOT)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build().apiInfo(new ApiInfoBuilder()
                        .title(applicationName + "接口文档")
                        .description(applicationName)
                        .version("1.0-SNAPSHOT")
                        .contact(new Contact("lianxf","www.lianxf.cn","lianxfly@163.com"))
                        .license("The Apache License")
                        .licenseUrl("http://www.lianxf.cn")
                        .build());
    }
}
