package com.example.kafka;


import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.junit.Test;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.kafka.listener.MessageListener;

import java.util.*;
import java.util.concurrent.Future;
import java.util.concurrent.locks.LockSupport;

/**
 * @author AmazingZ
 * @date 2019/8/20 15:56
 */
public class KafkaProducer {
    @Test
    public void testProducer() {

        Map<String, Object> configs = new HashMap<>();
        configs.putIfAbsent("bootstrap.servers", "119.3.10.221:9092");
        configs.putIfAbsent("acks", "all");
        DefaultKafkaProducerFactory<String, String> producerFactory = new DefaultKafkaProducerFactory<>(configs, new StringSerializer(), new StringSerializer());

        Producer<String, String> producer = producerFactory.createProducer();
        Future<RecordMetadata> future = producer.send(new ProducerRecord<>("test", "zzz"), new Callback() {
            @Override
            public void onCompletion(RecordMetadata metadata, Exception exception) {
                System.out.println();
            }
        });
        future.isDone();
        System.out.println();
        LockSupport.park(new Object());
    }

    @Test
    public void testConsumer() {

        Map<String, Object> configs = new HashMap<>();
        configs.putIfAbsent("bootstrap.servers", "119.3.10.221:9092");
        configs.put("group.id", "testzzz");
        configs.putIfAbsent("enable.auto.commit",false);
        ConsumerFactory<String, String> consumerFactory = new DefaultKafkaConsumerFactory<>(configs, new StringDeserializer(), new StringDeserializer());
//        consumerFactory.createConsumer().subscribe(Collections.singleton("test"));
        ContainerProperties containerProperties = new ContainerProperties("test");
        containerProperties.setClientId("213123123");
        Consumer<String,String> consumer= consumerFactory.createConsumer();
        TopicPartition topicPartition= new TopicPartition("test",0);
        consumer.assign(Collections.singleton(topicPartition));
        consumer.seek(topicPartition,0);
        consumer.commitAsync();
        ConsumerRecords<String,String> consumerRecords= consumer.poll(1000);
        System.out.println();
        ConcurrentMessageListenerContainer<String, String> kafkaMessageListenerContainer = new ConcurrentMessageListenerContainer<>(consumerFactory,containerProperties);
        kafkaMessageListenerContainer.setupMessageListener(new MessageListener<String, String>() {
            @Override
            public void onMessage(ConsumerRecord<String, String> data) {
                System.out.println("我收到消息了"+data.value());
                System.out.println();
                data.offset();
            }
        });
        kafkaMessageListenerContainer.start();
        LockSupport.park(new Object());
    }
}
