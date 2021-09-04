package cn.lianxf.cloud.websocket.config;

import cn.lianxf.cloud.websocket.interceptor.WebSocketInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @className WebSocketConfig
 * @description WebSocket配置
 * @date 2021/9/4 下午9:58
 * @author little
 * @version 1.0.0
 */
@Slf4j
@Configuration
public class WebSocketConfig implements WebSocketConfigurer {

    /**
     * 注入一个ServerEndpointExporter,该Bean会自动注册使用@ServerEndpoint注解申明的websocket endpoint
     */
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        //setAllowedOrigins 调试先关闭
        registry.addHandler(new WebSocketHandler() {
            @Override
            public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {

            }

            @Override
            public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {
                log.warn("messae: {}", webSocketMessage);
            }

            @Override
            public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {

            }

            @Override
            public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {

            }

            @Override
            public boolean supportsPartialMessages() {
                return false;
            }
        }, "/ws/**")
                // 这是不做域名拦截处理
                .setAllowedOrigins("*")
                // 这里添加自定义的拦截器
                .addInterceptors(new WebSocketInterceptor());
    }
}
