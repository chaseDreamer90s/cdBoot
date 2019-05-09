package com.dixn.dxboot.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * ${DESCRIPTION}
 *
 * @author
 * @create 2019-01-24 11:25
 **/
@Component
@Slf4j
public class KafkaReceiver {

    @KafkaListener(topics = {"test1"})
    public void listen(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            log.info("----------------- record =" + record);
            log.info("------------------ message =" + message);
        }
    }


    // 批量接收
    /*@KafkaListener(topics = {"test"}, containerFactory = "listenerContainerFactory")
    public void registryReceiver(List<ConsumerRecord<Integer, String>> integerStringConsumerRecords, Acknowledgment acknowledgment) {
        Iterator<ConsumerRecord<Integer, String>> it = integerStringConsumerRecords.iterator();
        while (it.hasNext()){
            ConsumerRecord<Integer, String> consumerRecords = it.next();
            //dosome
            acknowledgment.acknowledge();
        }
    }*/


    /*private static final String TPOIC = "test4";

    @KafkaListener(id = "id0", topicPartitions = { @TopicPartition(topic = TPOIC, partitions = { "0" }) })
    public void listenPartition0(ConsumerRecord<?, ?> record) {
        log.info("Id0 Listener, Thread ID: " + Thread.currentThread().getId());

        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
//        log.info("Received0: " + record);
        if (kafkaMessage.isPresent()) {
            Object message = record.value();
            String topic = record.topic();
            log.info("p0 Received message={}",  message);
        }
    }

    @KafkaListener(id = "id1", topicPartitions = { @TopicPartition(topic = TPOIC, partitions = { "1" }) })
    public void listenPartition1(ConsumerRecord<?, ?> record) {
        log.info("Id1 Listener, Thread ID: " + Thread.currentThread().getId());

        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
//        log.info("Received1: " + record);
        if (kafkaMessage.isPresent()) {
            Object message = record.value();
            String topic = record.topic();
            log.info("p1 Received message={}", message);
        }
    }*/
}
