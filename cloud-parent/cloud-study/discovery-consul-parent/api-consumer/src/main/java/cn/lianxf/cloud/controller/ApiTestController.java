package cn.lianxf.cloud.controller;

import cn.lianxf.cloud.client.ApiTestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @className ApiTestController
 * @description Api Test
 * @date 2021/8/15 下午4:55
 * @author little
 * @version 1.0.0
 */
@RestController
public class ApiTestController {

    @Autowired
    private ApiTestClient apiTestClient;

    @GetMapping("/test")
    public String test() {
        return apiTestClient.test();
    }

    @GetMapping("/test1")
    public String test1()
    {
        return apiTestClient.test1();
    }

    @GetMapping("/test2")
    public String test2() {
        return apiTestClient.test2();
    }
}
