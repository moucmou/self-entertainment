package com.example.amq;

import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.RedeliveryPolicy;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.jms.JmsException;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author AmazingZ
 * @date 2019/6/27 16:12
 */
@Slf4j
public class AmqProvider {

    public static void main(String[] args) throws Exception {
        Lock lock = new ReentrantLock();
        Thread thread = null;
        new Thread(()->{
            Thread.currentThread().setName("测试线程");
            for(Long i=0L;i<Long.MAX_VALUE;i++){
                System.out.println(i);
            }
        }).start();
        try {
            //加超时时间也能强制唤醒、但是没有amq集群就还是不要用failover了  ?timeout=3000
            // Create a ConnectionFactory
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("admin", "7Ta7uzbg", "failover:(tcp://10.19.132.205:7018)");
            final CachingConnectionFactory[] cachingConnectionFactory = {new CachingConnectionFactory(connectionFactory)};
            cachingConnectionFactory[0].setReconnectOnException(true);
            cachingConnectionFactory[0].setSessionCacheSize(10);
            // Create a Connection
            JmsTemplate jmsTemplate = new JmsTemplate(cachingConnectionFactory[0]);
            jmsTemplate.setSessionAcknowledgeMode(2);
            // 修改消息的有效时间，设置为60s（秒）
            jmsTemplate.setTimeToLive(120*60*1000);
            //jmsTemplate.setDefaultDestination(getDestination(destionName, isTopic));
            jmsTemplate.setDeliveryMode(DeliveryMode.PERSISTENT);
            jmsTemplate.setExplicitQosEnabled(true);
            // Create the destination (Topic or Queue)
            thread = new Thread(() -> {
                Thread.currentThread().setName("让我看看是哪个弟弟出问题了");
                int count = 30;
                while (count > 0) {
                    try {
                        Thread.sleep(1 * 5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        long start = System.currentTimeMillis();
                        jmsTemplate.send(new ActiveMQQueue("test.test.test")
                                , new MessageCreator() {
                                    @Override
                                    public Message createMessage(Session session) throws JMSException {
                                        TextMessage message = session.createTextMessage();
                                        System.err.println(session.getAcknowledgeMode());
                                        ;
                                        message.setText("草拟吗的凑比");
                                        return message;
                                    }
                                });
                        System.err.println("花费了多长时间" + (System.currentTimeMillis() - start) / 1000);

                        // Create a messages
                        String text = "Hello world! From: " + Thread.currentThread().getName();
                    } catch (JmsException e) {
//                        try {
//                            if (lock.tryLock(100, TimeUnit.MILLISECONDS)) {
//
//
//                                // Reset connection
//                                cachingConnectionFactory[0].resetConnection();
//                                cachingConnectionFactory[0] = new CachingConnectionFactory(connectionFactory);
////                                cachingConnectionFactory.setSessionCacheSize(jmsContextResolver.getSendSessionCacheSize());
//                                jmsTemplate.setConnectionFactory(cachingConnectionFactory[0]);
//                            }
//                        } catch (InterruptedException ex) {
//                            log.info("重连失败", ex);
//                        }

                        log.error("出错了", e);
                    }
                    count--;
                }
            });


            // Tell the producer to send the message


            // Clean up

        } catch (Exception e) {
            System.out.println("Caught: " + e);
            e.printStackTrace();
        }
        thread.start();
        thread.join();

    }
}
