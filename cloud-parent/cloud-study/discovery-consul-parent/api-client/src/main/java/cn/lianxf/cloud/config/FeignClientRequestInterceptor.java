package cn.lianxf.cloud.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @className FeignClientConfig
 * @description Feign Client Config
 * @date 2021/8/15 下午8:21
 * @author little
 * @version 1.0.0
 */
@Configuration
public class FeignClientRequestInterceptor implements RequestInterceptor {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void apply(RequestTemplate template) {
        // 传递令牌
        // 1.获取request请求
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes != null){
            HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
            // 2.获取所有的请求头
            Enumeration<String> headerNames = request.getHeaderNames();
            // 3.遍历所有的请求头名称
            while (headerNames.hasMoreElements()){
                String headerName = headerNames.nextElement();
                // 4.判断如果有Authorization 的请求头，则传递令牌
                if (HttpHeaders.AUTHORIZATION.equals(headerName)){
                    String headerValue = request.getHeader(headerName);
                    template.header(headerName, headerValue);
                }
            }
        }
        logger.error("----------------------feign interceptor----------------------");
    }
}
