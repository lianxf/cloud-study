package cn.lianxf.cloud.common.config;

import cn.lianxf.cloud.constant.PathConsts;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;
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
 * @date 2021/8/7 上午10:55
 * @author little
 * @version 1.0.0
 */
@ComponentScan(basePackages = "cn.lianxf.cloud"
        , excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = cn.lianxf.cloud.config.Swagger2Config.class)
})
@Slf4j
@EnableSwagger2
@Configuration
//  implements BeanFactoryPostProcessor, BeanDefinitionRegistryPostProcessor
public class Swagger2Config {

    @Value("${spring.application.name}")
    private String applicationName;

    @Bean
    public Docket createRestApi() {
        log.info("---------------overwrite swagger--------------");
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName(applicationName)
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

//    @Override
//    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
//        BeanDefinitionRegistry bdr = (BeanDefinitionRegistry)beanFactory;
//        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
//        BeanDefinition swaggerConfig = bdr.getBeanDefinition("swagger2Config");
//        log.info("-------------------swagger2Config: " + swaggerConfig.getBeanClassName());
//
//    }
//
//    @Override
//    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
//        BeanDefinition swagger2Config = beanDefinitionRegistry.getBeanDefinition("swagger2Config");
//        beanDefinitionRegistry.registerBeanDefinition("swagger2Config", swagger2Config);
//        BeanDefinition swaggerConfig = beanDefinitionRegistry.getBeanDefinition("swaggerConfig");
//        beanDefinitionRegistry.registerBeanDefinition("swagger2Config", swaggerConfig);
//    }
}
