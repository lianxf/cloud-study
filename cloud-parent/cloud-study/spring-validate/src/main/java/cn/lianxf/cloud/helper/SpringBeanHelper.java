package cn.lianxf.cloud.helper;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @className SpringBeanHelper
 * @description 获取SpringBean
 * @date 2021/9/8 下午8:54
 * @author little
 * @version 1.0.0
 */
@Component
public class SpringBeanHelper implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        SpringBeanHelper.context = context;
    }

    public static <T> T getBean(Class<T> clazz) {
        return context.getBean(clazz);
    }
}
