package cn.lianxf.cloud.config;

import cn.lianxf.cloud.exception.ApiClientException;
import feign.FeignException;
import feign.Logger;
import feign.Response;
import feign.RetryableException;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/**
 * @className FeignErrorDecoder
 * @description Feign Error Decoder
 * @date 2021/8/15 下午5:15
 * @author little
 * @version 1.0.0
 */
@Slf4j
@Configuration
public class FeignErrorDecoder extends ErrorDecoder.Default {

    @Override
    public Exception decode(String methodKey, Response response) {
        Exception exception = super.decode(methodKey, response);

        // 如果是RetryableException，则返回继续重试
        if (exception instanceof RetryableException) {
            return exception;
        }
        try {
            // 如果是FeignException，则对其进行处理，并抛出BusinessException
            if (exception instanceof FeignException && ((FeignException) exception).responseBody().isPresent()) {
                ByteBuffer responseBody = ((FeignException) exception).responseBody().get();
                String bodyText = StandardCharsets.UTF_8.newDecoder().decode(responseBody.asReadOnlyBuffer()).toString();
                log.info(bodyText);
//                // 将异常信息，转换为ExceptionInfo对象
//                ExceptionInfo exceptionInfo = JSON.parseObject(bodyText, ExceptionInfo.class);
//                // 如果excepiton中code不为空，则使用该code，否则使用默认的错误code
//                Integer code = Optional.ofNullable(exceptionInfo.getCode()).orElse(ResultCodeEnum.ERROR.getCode());
//                // 如果excepiton中message不为空，则使用该message，否则使用默认的错误message
//                String message = Optional.ofNullable(exceptionInfo.getMessage()).orElse(ResultCodeEnum.ERROR.getMessage());
//                return new BusinessException(code, message);
            }
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
        }
        return new ApiClientException();
    }
}
