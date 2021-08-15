package cn.lianxf.cloud.client;

import cn.lianxf.cloud.config.FeignErrorDecoder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @className ApiTestClient
 * @description ApiTestClient
 * @date 2021/8/15 下午4:46
 * @author little
 * @version 1.0.0
 */
@FeignClient(name = "api-provider", fallback = ApiTestFallbackFactory.class/*configuration = {FeignErrorDecoder.class}*/)
public interface ApiTestClient {

    @GetMapping("/test")
    String test();

    @GetMapping("/test1")
    String test1();

    @GetMapping("/test2")
    String test2();
}
