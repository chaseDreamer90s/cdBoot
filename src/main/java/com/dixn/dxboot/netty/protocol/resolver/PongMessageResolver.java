package com.dixn.dxboot.netty.protocol.resolver;

import com.dixn.dxboot.netty.protocol.pojo.Message;
import com.dixn.dxboot.netty.protocol.pojo.MessageTypeEnum;

// pong消息处理器
public class PongMessageResolver implements Resolver {

    @Override
    public boolean support(Message message) {
        return message.getMessageType() == MessageTypeEnum.PONG;
    }

    @Override
    public Message resolve(Message message) {
        // 接收到pong消息后，不需要进行处理，直接返回一个空的message
        System.out.println("receive pong message: " + System.currentTimeMillis());
        Message empty = new Message();
        empty.setMessageType(MessageTypeEnum.EMPTY);
        return empty;
    }
}