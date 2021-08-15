package cn.lianxf.cloud.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @className GlobalExceptionAdvice
 * @description 全局异常处理
 * @date 2021/8/15 下午7:55
 * @author little
 * @version 1.0.0
 */
@ControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler(ApiClientException.class)
    public String apiClientException(ApiClientException e) {
        return e.getMessage();
    }

    @ExceptionHandler(Exception.class)
    public String exception(Exception e) {
        e.printStackTrace();
        return e.getMessage();
    }
}
