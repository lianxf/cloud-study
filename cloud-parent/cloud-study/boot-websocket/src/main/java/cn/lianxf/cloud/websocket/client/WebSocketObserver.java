package cn.lianxf.cloud.websocket.client;

import cn.hutool.core.collection.CollUtil;
import cn.lianxf.cloud.websocket.event.MessageEvent;
import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @className WebSocketClient
 * @description WebSocket 客户端
 * @date 2021/9/4 下午10:04
 * @author little
 * @version 1.0.0
 */
@ServerEndpoint(value = "/ws/{id}")
@Slf4j
@Component
public class WebSocketObserver {

    private final static ConcurrentHashMap<String, List<Session>> ONLINE_MAP = new ConcurrentHashMap<>(256);

    private final static ConcurrentHashMap<String, String> USER_SESSIONID_MAP = new ConcurrentHashMap<>(256);


    /** 记录当前在线连接数 */
    private static final AtomicInteger ONLINE = new AtomicInteger(0);

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("id")String id) {
        // 在线数加1
        ONLINE.incrementAndGet();
        List<Session> sessions = ONLINE_MAP.get(id);
        if (CollUtil.isNotEmpty(sessions)) {
            sessions.add(session);
        } else {
            sessions = new ArrayList<>();
            sessions.add(session);
        }
        ONLINE_MAP.put(id, sessions);
        log.info("有新连接加入：{}，当前在线人数为：{}", session.getId(), ONLINE.get());
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(Session session, @PathParam("id")String id) {
        // 在线数减1
        ONLINE.decrementAndGet();
        List<Session> sessions = ONLINE_MAP.get(id);
        if (CollUtil.isNotEmpty(sessions) && sessions.contains(session)) {
            sessions.removeIf(session::equals);
        }
        log.info("有一连接关闭：{}，当前在线人数为：{}", session.getId(), ONLINE.get());
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("服务端收到客户端[{}]的消息:{}", session.getId(), message);
    }

    @OnError
    public void onError(Session session, Throwable error) {
        log.error("发生错误", error);
    }

    /**
     * 服务端发送消息给客户端
     */
    @Subscribe
    private void sendMessage(MessageEvent event) {
        try {
            List<Session> sessions = ONLINE_MAP.get(event.getId());
            if (CollUtil.isNotEmpty(sessions)) {
                for (Session session : sessions) {
                    session.getBasicRemote().sendText(event.getMessage());
                }
            }
        } catch (Exception e) {
            log.error("服务端发送消息给客户端失败。", e);
        }
    }
}
