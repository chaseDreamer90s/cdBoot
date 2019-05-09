package com.dixn.dxboot.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

/**
 * @Description：send mq info according to deviceType
 * @projectName：FCS
 * @packageName： com.dixn.mq
 * @ClassName：zhaoxu
 * @author：zhaoxu
 * @createTime：2018/9/8 9:43
 * @upate：zhaoxu
 * @updateDate：2018/9/8 9:43
 * @remark：
 * @version v1.0
 */
@Component
public class MqSend {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendMessage(Queue queue, String message) {
        jmsTemplate.convertAndSend(queue, message);
    }
}
