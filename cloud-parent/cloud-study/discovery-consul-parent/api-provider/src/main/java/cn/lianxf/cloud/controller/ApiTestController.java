package cn.lianxf.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @className ApiTestController
 * @description Api Test
 * @date 2021/8/15 下午4:43
 * @author little
 * @version 1.0.0
 */
@RestController
public class ApiTestController {

    @GetMapping("/test")
    public String test() {
        return "ok";
    }

    @GetMapping("/test1")
    public String test1() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        return "ok";
    }

    @GetMapping("/test2")
    public String test2() {
        int i = 1/0;
        return "ok";
    }


}
