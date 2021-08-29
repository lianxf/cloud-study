package cn.lianxf.arthas.boot.exception;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @className GlobalExceptionAdvice
 * @description 全局异常处理器
 * @date 2021/7/11 下午3:09
 * @author little
 * @version 1.0.0
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionAdvice {


    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Map<String, String> exception(Exception e, HttpServletRequest request) {
      log.error(errorLog(e, request), e);
      Map<String, String> result = new HashMap<>(16);
      result.put("exception", e.getClass().getName());
      result.put("message", e.getMessage());
      result.put("code", "500");
      return result;
    }



    private String errorLog(Exception e, HttpServletRequest request) {
        String errorLog = "----------------------------RequestURI:" + request.getRequestURI()
                + " Exception:" + e.getClass().getName() + "----------------------------\n";
        errorLog += "RequestHeaders:" + requestHeaderStr(request) + "\n";
        errorLog += "RequestParams:" + requestParamStr(request) + "\n";
        errorLog += "RemoteIp:" + request.getRemoteHost();
        return errorLog;
    }


    private String requestHeaderStr(HttpServletRequest request) {
        Enumeration<String> headerNames = request.getHeaderNames();
        StringBuilder headStr = new StringBuilder();
        while (headerNames.hasMoreElements()) {
            String header = headerNames.nextElement();
            headStr.append(header).append("=").append(request.getHeader(header)).append(";");
        }
        return headStr.toString();
    }

    private String requestParamStr(HttpServletRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        StringBuilder paramStr = new StringBuilder();
        for (Map.Entry<String, String[]> paramEntry : parameterMap.entrySet()) {
            paramStr.append(paramEntry.getKey()).append("=");
            try {
                paramStr.append(JSON.toJSONString(paramEntry.getValue()));
            } catch (Exception e) {
                paramStr.append("无法解析对象");
            }
            paramStr.append(";");
        }
        return paramStr.toString();
    }
}
