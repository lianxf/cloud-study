package cn.lianxf.cloud.handler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.handler.timeout.IdleStateHandler;

/**
 * @className WebScoketChannelInitializer
 * @description
 * @date 2021/9/11 下午2:42
 * @author little
 * @version 1.0.0
 */
public class WebScoketChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new HttpServerCodec());
        pipeline.addLast(new ChunkedWriteHandler());
        pipeline.addLast(new HttpObjectAggregator(1024*64));
        pipeline.addLast(new IdleStateHandler(8, 10, 12));
        pipeline.addLast(new WebSocketServerProtocolHandler("/lbh"));
        pipeline.addLast(new WebScoketMessageHandler());
    }
}
