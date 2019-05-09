package com.dixn.dxboot.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.IdleStateHandler;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @Description：ServerChannelPipelineFactory
 *
 * @projectName：fcs-modbus
 * @ClassName：ServerChannelPipelineFactory
 * @author：tan10ler
 * @createTime：Oct 23, 2018 8:12:55 AM
 * @update：tan10ler
 * @updateDate：Oct 23, 2018 8:12:55 AM
 * @version v1.0
 */
@Slf4j
@Data
public class ServerChannelPipelineFactory {

	private static final int connection_timeout = 5;

	private String tcpPort;

	public void run() throws Exception {

		// Helper class
		EventLoopGroup bossGroup = new NioEventLoopGroup();

		// Helper class
		EventLoopGroup workerGroup = new NioEventLoopGroup();

		try {

			// ServerBootstrap is a secondary startup class that starts the NIO
			// service. You can use Channel directly in this service.
			ServerBootstrap b = new ServerBootstrap();

			// This step is required. If you do not set the group, it will
			// report java.lang.IllegalStateException: group not set exception
			b = b.group(bossGroup, workerGroup);

			// ServerSocketChannel is implemented on the basis of NIO's selector
			// to receive new connections.
			// This tells Channel how to get a new connection.
			b = b.channel(NioServerSocketChannel.class);

			// Configuring business handler
			b = b.childHandler(new ChannelInitializer<SocketChannel>() {
				@Override
				public void initChannel(SocketChannel ch) throws Exception {
					ch.pipeline().addLast(new LoggingHandler(LogLevel.INFO));
					ch.pipeline().addLast(new IdleStateHandler(connection_timeout, 0, 0, TimeUnit.MINUTES));
                    ch.pipeline().addLast(new StringDecoder());
                    ch.pipeline().addLast(new StringEncoder());
					// 处理业务类
					ch.pipeline().addLast(new ChannelHandler());
				}
			});

			// ChannelOption.SO_BACKLOG corresponds to the backlog parameter in
			// the tcp/ip protocol listen function. The function listen(int
			// socketfd, int backlog) is used to initialize the
			// server-connectable queue. The server handles the client
			// connection request in sequence, so the same time Only one client
			// connection can be processed. When multiple clients come, the
			// client will not process the client connection request in the
			// queue for processing. The backlog parameter specifies the size of
			// the queue.
			b = b.option(ChannelOption.SO_BACKLOG, 128);

			// Monitor active connections
			b = b.childOption(ChannelOption.SO_KEEPALIVE, true);

			// Bind the port and start to receive incoming connections
			int port = Integer.parseInt(tcpPort);
            log.info("Tcp server start,port:" + port);
			ChannelFuture f = b.bind(port).sync();

			// Still waiting until the socket is closed
			f.channel().closeFuture().sync();
		} finally {
			// Elegant close
			workerGroup.shutdownGracefully();
			bossGroup.shutdownGracefully();
		}
	}
}
