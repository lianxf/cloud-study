package cn.lianxf.cloud.websocket.event;

import lombok.Builder;
import lombok.Data;

/**
 * @className MessageEvent
 * @description message event
 * @date 2021/9/4 下午10:21
 * @author little
 * @version 1.0.0
 */
@Builder
@Data
public class MessageEvent {

    private String id;

    private String message;
}
