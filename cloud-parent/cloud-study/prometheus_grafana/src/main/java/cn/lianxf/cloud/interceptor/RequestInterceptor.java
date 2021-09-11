package cn.lianxf.cloud.interceptor;

import io.micrometer.core.instrument.Timer;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import io.prometheus.client.Counter;
import io.prometheus.client.Histogram;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @className WebFilter
 * @description web 请求过滤器
 * @date 2021/9/5 下午5:53
 * @author little
 * @version 1.0.0
 */
@Component
public class RequestInterceptor implements HandlerInterceptor {

//    Counter requestCounter = Counter.build()
//            .name("request_counter")
//            .labelNames("method", "uri")
//            .help("http request total count")
//            .register();
    Histogram histogram = Histogram.build()
            .name("http_server_request_time_seconds")
            .labelNames("method", "url", "code")
            .help("request duration")
            .register();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        requestCounter.labels(request.getMethod(), request.getRequestURI()).inc();
        histogram.labels(request.getMethod(), request.getRequestURI()).startTimer();
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        histogram.observe(0.0d);
    }
}
