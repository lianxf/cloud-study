package cn.lianxf.cloud;

import cn.lianxf.cloud.config.Swagger2Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * @className SwaggerConfigOverwriteApplication
 * @description 主启动类
 * @date 2021/8/7 上午10:51
 * @author little
 * @version 1.0.0
 */
@SpringBootApplication
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type =
        FilterType.ASSIGNABLE_TYPE, classes = {Swagger2Config.class})})
public class SwaggerConfigOverwriteApplication {
    public static void main(String[] args) {
        SpringApplication.run(SwaggerConfigOverwriteApplication.class);
    }
}
