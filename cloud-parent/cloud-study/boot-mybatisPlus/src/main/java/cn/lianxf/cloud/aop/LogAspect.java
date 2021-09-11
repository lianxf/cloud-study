package cn.lianxf.cloud.aop;

import cn.hutool.json.JSONUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

/**
 * @className LogAspect
 * @description 日志切面
 * @date 2021/9/10 下午9:44
 * @author little
 * @version 1.0.0
 */

@Slf4j
@Component
@Aspect
public class LogAspect {

    @Autowired
    private HttpServletRequest request;

    @Pointcut("execution(* cn.lianxf.cloud.controller.*Controller..*(..))")
    public void pointcut(){}


    @Around("pointcut()")
    public Object doInvoke(ProceedingJoinPoint pjp) throws Throwable {
        Object result = null;
        Object[] args = pjp.getArgs();
        LogInfo info = buildLogInfo(pjp);
        try {
            log.info("[LogAspect:before] {}", info);
            result = pjp.proceed(args);
            info.setResult(JSONUtil.toJsonStr(result));
            log.info("[LogAspect:afterReturn] {}", info);
        } catch (Throwable throwable) {
            info.setErrMsg(throwable.getMessage());
            info.setException(throwable.getClass().getName());
            log.info("[LogAspect:throwing] {}", info, throwable);
            throw throwable;
        }
        return result;
    }

    private LogInfo buildLogInfo(ProceedingJoinPoint pjp) {
        LogInfo info = new LogInfo();
        info.setLogId(System.currentTimeMillis());
        info.setMethod(pjp.getSignature().getName());
        info.setParam(JSONUtil.toJsonStr(pjp.getArgs()));
        info.setUri(request.getRequestURI());
        return info;
    }

    @Data
    public static class LogInfo implements Serializable {

        private static final long serialVersionUID = -7479229736700027457L;

        private Long logId;

        private String uri;

        private String method;

        private String param;

        private String result;

        private String exception;

        private String errMsg;
    }
}
