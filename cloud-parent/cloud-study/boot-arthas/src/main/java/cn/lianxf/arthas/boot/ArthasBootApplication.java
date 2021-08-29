package cn.lianxf.arthas.boot;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("cn.lianxf.arthas.boot.mapper")
@EnableAdminServer
@SpringBootApplication
public class ArthasBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArthasBootApplication.class, args);
    }

}
