package cn.lianxf.cloud.client;

import org.springframework.stereotype.Component;

/**
 * @className ApiTestFallbackFactory
 * @description Api Test Fallback
 * @date 2021/8/15 下午10:17
 * @author little
 * @version 1.0.0
 */
@Component
public class ApiTestFallbackFactory implements ApiTestClient{
    @Override
    public String test() {
        return "fallback test";
    }

    @Override
    public String test1() {
        return "fallback test1";
    }

    @Override
    public String test2() {
        return "fallback test2";
    }
}
