package com.dixn.dxboot.netty.LengthFieldBased.client;

import com.dixn.dxboot.netty.LengthFieldBased.pojo.CustomMsg;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class CustomClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        /*CustomMsg customMsg = new CustomMsg((byte) 0xAB, (byte) 0xCD, "Hello,Netty".length(), "Hello,Netty");
        ctx.writeAndFlush(customMsg);*/

        byte[] dd = new byte[]{0, 2, 0, 0, 0, 9, 1, 10, 0, 4, 0, 1, 2, 0, 1};

        ByteBuf wrappedBuffer = Unpooled.wrappedBuffer(dd);
        if (ctx != null) {
            ctx.writeAndFlush(wrappedBuffer);
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        ByteBuf in = (ByteBuf) msg;

        System.out.println("head01 :" + in.readUnsignedByte());
        System.out.println("head02 :" + in.readUnsignedByte());
        System.out.println("head03 :" + in.readUnsignedByte());
        System.out.println("命令字 :" + in.readUnsignedByte());
        System.out.println("控制器地址无效 :" + in.readUnsignedByte());
        System.out.println("控制器地址无效 :" + in.readUnsignedByte());
        System.out.println("控制器地址有效数据 :" + in.readUnsignedByte());
        System.out.println("计算机地址 :" + in.readUnsignedByte());
        System.out.println("数据长度 :" + in.readUnsignedByte());
        System.out.println("数据 :" + in.readUnsignedByte());

//        super.channelRead(ctx, msg);
    }

}
