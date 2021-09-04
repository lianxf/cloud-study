package cn.lianxf.cloud.websocket.event;

import cn.lianxf.cloud.websocket.client.WebSocketObserver;
import com.google.common.eventbus.EventBus;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @className EventBus
 * @description 事件总线
 * @date 2021/9/4 下午9:15
 * @author little
 * @version 1.0.0
 */

@Component
public class EventPublisher implements InitializingBean, ApplicationContextAware {

    private ApplicationContext applicationContext;

    public static final EventBus BUS = new EventBus("message");

    @Override
    public void afterPropertiesSet() throws Exception {
        BUS.register(applicationContext.getBean(WebSocketObserver.class));
    }

    public void post(Object event) {
        BUS.post(event);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
