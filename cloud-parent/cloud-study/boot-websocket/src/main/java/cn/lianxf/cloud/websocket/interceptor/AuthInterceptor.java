package cn.lianxf.cloud.websocket.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @className AuthInterceptor
 * @description 认证信息拦截
 * @date 2021/9/4 下午10:42
 * @author little
 * @version 1.0.0
 */
@Slf4j
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.warn("requestURL: {}", request.getRequestURL().toString() );
        return true;
    }
}
