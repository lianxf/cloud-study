package cn.lianxf.cloud.websocket.controller;

import cn.lianxf.cloud.websocket.event.EventPublisher;
import cn.lianxf.cloud.websocket.event.MessageEvent;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className TestController
 * @description 测试
 * @date 2021/9/4 下午10:30
 * @author little
 * @version 1.0.0
 */

@AllArgsConstructor
@RestController
public class TestController {

    private final EventPublisher eventPublisher;

    @GetMapping("/test")
    public String test() {
        eventPublisher.post(MessageEvent.builder().id("1").message("test").build());
        return "ok";
    }

}
