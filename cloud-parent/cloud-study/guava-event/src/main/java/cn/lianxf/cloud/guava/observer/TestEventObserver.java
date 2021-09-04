package cn.lianxf.cloud.guava.observer;

import cn.lianxf.cloud.guava.event.TestEvent;
import cn.lianxf.cloud.guava.event.TestEvent2;
import cn.lianxf.cloud.guava.event.TestEvent3;
import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;

/**
 * @className EventObserver
 * @description 事件监听 观察者
 * @date 2021/9/4 下午9:21
 * @author little
 * @version 1.0.0
 */
@Slf4j
public class TestEventObserver {

    @Subscribe
    public void testEvent(TestEvent event) {
      log.error("TestEvent:{}", event);
    }

    @Subscribe
    public void testEvent2(TestEvent2 event) {
        log.error("TestEvent2:{}", event);
    }

    @Subscribe
    public void testEven3t(TestEvent3 event) {
        log.error("TestEvent3:{}", event);
    }
}
