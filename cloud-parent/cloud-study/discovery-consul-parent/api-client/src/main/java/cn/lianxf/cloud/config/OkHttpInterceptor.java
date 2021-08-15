package cn.lianxf.cloud.config;

import lombok.extern.slf4j.Slf4j;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @className OkHttpInterceptor
 * @description Ok Http Client Interceptor
 * @date 2021/8/15 下午8:34
 * @author little
 * @version 1.0.0
 */
@Slf4j
@Component
public class OkHttpInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
       log.error("----------------------okhttp before----------------------");
        Response response = chain.proceed(request);
       log.error("----------------------okhttp after----------------------s");
        return response;
    }
}
