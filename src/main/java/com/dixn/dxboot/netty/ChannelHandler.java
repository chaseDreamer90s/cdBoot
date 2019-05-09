package com.dixn.dxboot.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;

/**
 * 
 * @Description：TCP link message listening class
 *
 * @projectName：FCS
 * @ClassName：ChannelHandler
 * @author：tan10ler
 * @createTime：Aug 31, 2018 9:16:40 AM
 * @update：tan10ler
 * @updateDate：Aug 31, 2018 9:16:40 AM
 * @version v1.0
 */
@Slf4j
public class ChannelHandler extends SimpleChannelInboundHandler<String> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String s) throws Exception {
        log.info("接收客户端的数据:" + s);

        // TODO 在这个方法里面写业务处理，可以多线程处理业务
    }

    /**
     * @Description:上线
     * @Param
     * @author：zhaoxu
     * @createTime：2018/11/21-11:28
     * @updateUser：zhaoxu
     * @UpdateTime：2018/11/21-11:28
     * @UpdateRemark：
     * @throws
     * @return：
     * @version：1.0
     **/
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("连接的客户端地址:" + ctx.channel().remoteAddress());
        ctx.writeAndFlush("客户端"+ InetAddress.getLocalHost().getHostName() + "成功与服务端建立连接！ \n");
        super.channelActive(ctx);
    }

    /**
     * @Description:下线
     * @Param
     * @author：zhaoxu
     * @createTime：2018/11/21-11:28
     * @updateUser：zhaoxu
     * @UpdateTime：2018/11/21-11:28
     * @UpdateRemark：
     * @throws
     * @return：
     * @version：1.0
     **/
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        log.info("掉线的客户端地址:" + ctx.channel().remoteAddress());
    }

    /**
     * @Description:异常
     * @Param 
     * @author：zhaoxu
     * @createTime：2018/11/21-11:32
     * @updateUser：zhaoxu
     * @UpdateTime：2018/11/21-11:32
     * @UpdateRemark：
     * @throws 
     * @return：
     * @version：1.0
     **/
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        log.info("Session exception,ip:" + ctx.channel().remoteAddress());
        cause.printStackTrace();
        ctx.close();
    }

    
    /**
     * @Description:心跳
     * @Param 
     * @author：zhaoxu
     * @createTime：2018/11/21-11:32
     * @updateUser：zhaoxu
     * @UpdateTime：2018/11/21-11:32
     * @UpdateRemark：
     * @throws 
     * @return：
     * @version：1.0
     **/
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        super.userEventTriggered(ctx, evt);
        if (evt instanceof IdleStateEvent) {
            IdleState state = ((IdleStateEvent) evt).state();
            if (state == IdleState.READER_IDLE) {
                ctx.close();
            }
        }
    }

}
