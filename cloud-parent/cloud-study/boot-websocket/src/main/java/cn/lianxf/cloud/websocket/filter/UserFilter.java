package cn.lianxf.cloud.websocket.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * @className UserFilter
 * @description 用户信息 filter
 * @date 2021/9/4 下午10:44
 * @author little
 * @version 1.0.0
 */
@Component
@Slf4j
public class UserFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.warn("request protocol: {}", servletRequest.getProtocol());
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
