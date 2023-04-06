package com.dixn.dxboot;


import com.dixn.dxboot.netty.ServerChannelPipelineFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
//import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @Description：start up
 * @projectName：dxboot
 * @packageName： com.dixn.dxboot
 * @ClassName：StartUp
 * @author：zhaoxu
 * @createTime：2018/11/19 18:30
 * @upate：zhaoxu
 * @updateDate：2018/11/19 18:30
 * @remark：
 * @version v1.0
 */
@Component
@Order(value = 1)
@Slf4j
public class StartUp implements ApplicationRunner {

    @Value("${tcp.port}")
    String tcpPort;

    @Autowired
//    KafkaTemplate kafkaTemplate;

	@Override
	public void run(ApplicationArguments var1) throws Exception {
	    log.info("netty server start......... ");
        //kafkaTemplate.send("test1", "122");
        //startTcpServer();
	}

    public void startTcpServer() throws Exception {
        ServerChannelPipelineFactory serverChannelPipelineFactory = new ServerChannelPipelineFactory();
        serverChannelPipelineFactory.setTcpPort(tcpPort);
        serverChannelPipelineFactory.run();
    }

}
