package cn.lianxf.cloud.server;

import cn.lianxf.cloud.handler.WebScoketChannelInitializer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @className NettyServer
 * @description netty server
 * @date 2021/9/11 下午2:36
 * @author little
 * @version 1.0.0
 */
public class NettyServer {

    public void start() {
        EventLoopGroup mainGroup = new NioEventLoopGroup();
        EventLoopGroup subGroup  = new NioEventLoopGroup();
        try {
            ServerBootstrap server = new ServerBootstrap();
            server.group(mainGroup,subGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new WebScoketChannelInitializer())
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);
            // 服务器异步创建绑定
            ChannelFuture cf = server.bind(9123).sync();
            System.out.println(NettyServer.class + " 启动正在监听： " + cf.channel().localAddress());
            // 关闭服务器通道
            cf.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // 释放线程池资源
                mainGroup.shutdownGracefully().sync();
                subGroup.shutdownGracefully().sync();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
