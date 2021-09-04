package cn.lianxf.cloud.websocket.config;

import cn.lianxf.cloud.websocket.interceptor.AuthInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @className WebMvcConfig
 * @description Web配置
 * @date 2021/9/4 下午10:49
 * @author little
 * @version 1.0.0
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 可添加多个
        registry.addInterceptor(new AuthInterceptor()).addPathPatterns("/**");
    }
}
