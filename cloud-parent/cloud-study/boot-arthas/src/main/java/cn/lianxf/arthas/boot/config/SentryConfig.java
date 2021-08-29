package cn.lianxf.arthas.boot.config;

import io.sentry.protocol.User;
import io.sentry.spring.SentryUserProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @className SentryConfig
 * @description Sentry相关配置
 * @date 2021/8/2 下午11:37
 * @author little
 * @version 1.0.0
 */
@Configuration
public class SentryConfig {

    @Bean
    public SentryUserProvider sentryUserProvider(){
        return () -> {
            // 实际的用户信息，可能要通过其他方式获得
            User user = new User();
            user.setId("20180723");
            user.setUsername("lianxf");
            user.setEmail("lianxf@gmail.com");
            return user;
        };
    }


//    @Bean
//    public SentryOptions.BeforeSendCallback beforeSendCallback(){
//        return (event, hint) -> {
//            List<SentryException> exceptions = event.getExceptions();
//
//            event.setTag("name","zhangsan");
//            return event;
//        };
//    }

}
