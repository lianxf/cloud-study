package cn.lianxf.cloud.guava.publish;

import cn.lianxf.cloud.guava.event.TestEvent;
import cn.lianxf.cloud.guava.observer.TestEventObserver;
import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @className EventBus
 * @description 事件总线
 * @date 2021/9/4 下午9:15
 * @author little
 * @version 1.0.0
 */

@Component
public class EventPublisher implements InitializingBean {

    public static final EventBus BUS = new EventBus("test");


    @Override
    public void afterPropertiesSet() throws Exception {
        BUS.register(new TestEventObserver());
    }

    public void post(Object event) {
        BUS.post(event);
    }
}
