package cn.lianxf.cloud.exception;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @className GlobalExceptionHandler
 * @description 全局异常处理
 * @date 2021/9/8 下午9:32
 * @author little
 * @version 1.0.0
 */

@ResponseBody
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handlerException(Exception e) {
        e.printStackTrace();
        if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException exception = (MethodArgumentNotValidException)e;
            return exception.getBindingResult().getFieldError().getDefaultMessage();
        }
        return e.getMessage();
    }
}
