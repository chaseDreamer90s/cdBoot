package com.dixn.dxboot.netty.protocol.resolver;

import com.dixn.dxboot.netty.protocol.pojo.Message;

public interface Resolver {

    boolean support(Message message);

    Message resolve(Message message);
}
