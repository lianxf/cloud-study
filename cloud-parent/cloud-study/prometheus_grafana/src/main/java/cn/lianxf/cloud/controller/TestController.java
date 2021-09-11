package cn.lianxf.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className TestController
 * @description 测试
 * @date 2021/9/5 下午6:11
 * @author little
 * @version 1.0.0
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "Ok";
    }
    @GetMapping("/test1")
    public String test1() {
        return "Ok";
    }
    @GetMapping("/test2")
    public String test2() {
        return "Ok";
    }
    @GetMapping("/test3")
    public String test3() {
        return "Ok";
    }@GetMapping("/test4")
    public String test4() {
        return "Ok";
    }

}
