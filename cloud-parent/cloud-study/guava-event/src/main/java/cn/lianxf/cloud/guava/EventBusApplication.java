package cn.lianxf.cloud.guava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @className EventBusApplication
 * @description 主启动类
 * @date 2021/9/4 下午9:37
 * @author little
 * @version 1.0.0
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class EventBusApplication {
    public static void main(String[] args) {
        SpringApplication.run(EventBusApplication.class);
    }
}
