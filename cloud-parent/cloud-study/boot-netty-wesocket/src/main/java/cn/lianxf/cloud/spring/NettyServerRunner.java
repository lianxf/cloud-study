package cn.lianxf.cloud.spring;

import cn.lianxf.cloud.server.NettyServer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @className NettyServerRunner
 * @description 启动netty server
 * @date 2021/9/11 下午2:37
 * @author little
 * @version 10
 */
@Component
public class NettyServerRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        new NettyServer().start();
    }
}
