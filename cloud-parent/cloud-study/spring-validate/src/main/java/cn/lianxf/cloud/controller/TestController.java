package cn.lianxf.cloud.controller;

import cn.lianxf.cloud.entity.SoftProduct;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className TestController
 * @description 测试接口
 * @date 2021/9/8 下午9:30
 * @author little
 * @version 1.0.0
 */
@RestController
public class TestController {


    @PostMapping("/test")
    public String test(@Validated @RequestBody SoftProduct product) {
        return "ok";
    }
}
