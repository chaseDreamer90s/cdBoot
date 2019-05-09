package com.dixn.dxboot.mq;

import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.DeliveryMode;
import javax.jms.Queue;

/**
 * @Description：MQ config class
 * @projectName：FCS
 * @packageName： com.dixn.mq
 * @ClassName：zhaoxu
 * @author：zhaoxu
 * @createTime：2018/8/31 14:23
 * @upate：zhaoxu
 * @updateDate：2018/8/31 14:23
 * @remark：
 * @version v1.0
 */
@Configuration
@Slf4j
public class MqConfig {

	@Value("${spring.activemq.broker-url}")
	private String activeMQ_URL;

	@Value("${spring.activemq.user}")
	private String activeMQ_USER;

	@Value("${spring.activemq.password}")
	private String activeMQ_PASSWORD;

	@Value("${receive_queue}")
	private String receive_queue;

	@Value("${send_queue}")
	private String send_queue;

	@Value("${response_queue}")
	private String alarm_queue;

	@Value("${response_queue}")
	private String response_queue;

	@Bean
	public ActiveMQConnectionFactory connectionFactory() {
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
		connectionFactory.setBrokerURL(activeMQ_URL);
		connectionFactory.setUserName(activeMQ_USER);
		connectionFactory.setPassword(activeMQ_PASSWORD);
		connectionFactory.setUseAsyncSend(true);
		return connectionFactory;
	}

	@Bean
	public CachingConnectionFactory cachingConnectionFactory() {
		return new CachingConnectionFactory(connectionFactory());
	}

	@Bean
	public DefaultJmsListenerContainerFactory jmsQueueListenerContainerFactory() {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory());
		factory.setConcurrency("3-10");
		return factory;
	}

	@Bean
	public JmsTemplate jmsTemplate() {
		JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory());
		//jmsTemplate.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
		//jmsTemplate.setSessionTransacted(false);
		jmsTemplate.setPubSubDomain(false);
        jmsTemplate.setExplicitQosEnabled(true);
        jmsTemplate.setTimeToLive(10000);
		return jmsTemplate;
	}

	@Bean
	public Queue receiveQueue() {
		return new ActiveMQQueue(receive_queue);
	}

	@Bean
	public Queue sendQueue() {
		return new ActiveMQQueue(send_queue);
	}

	@Bean
	public Queue sendAlarmQueue() {
		return new ActiveMQQueue(alarm_queue);
	}

	@Bean
	public Queue responseQueue() {
		return new ActiveMQQueue(response_queue);
	}
}
