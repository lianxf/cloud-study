package cn.lianxf.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @className ApiConsumerApplication
 * @description 主启动类
 * @date 2021/8/15 下午4:53
 * @author little
 * @version 1.0.0
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ApiConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiConsumerApplication.class);
    }
}
