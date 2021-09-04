package cn.lianxf.cloud.guava.controller;

import cn.lianxf.cloud.guava.event.TestEvent;
import cn.lianxf.cloud.guava.event.TestEvent2;
import cn.lianxf.cloud.guava.event.TestEvent3;
import cn.lianxf.cloud.guava.publish.EventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className TestController
 * @description 测试
 * @date 2021/9/4 下午9:38
 * @author little
 * @version 1.0.0
 */
@RestController
public class TestController {

    @Autowired
    private EventPublisher eventPublisher;

    @GetMapping("/test")
    public String test() {
        TestEvent event = new TestEvent();
        event.setData("test event");
        eventPublisher.post(event);
        TestEvent2 event2 = new TestEvent2();
        event2.setId(1);
        eventPublisher.post(event2);
        TestEvent3 event3 = new TestEvent3();
        event3.setId(2);
        event3.setData("test event3");
        eventPublisher.post(event3);
        return "ok";
    }
}
