package com.example.amq;

import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQMessageConsumer;
import org.apache.activemq.ActiveMQPrefetchPolicy;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.jms.listener.SimpleMessageListenerContainer;
import org.springframework.jms.listener.adapter.MessageListenerAdapter;

import javax.jms.*;

/**
 * @author AmazingZ
 * @date 2019/6/27 16:23
 */
@Slf4j
public class AmqListener {


    public AmqListener() {
        System.out.println("cao nima wo bei chushihua le ");
    }

    public static void main(String[] args) {

        try {
            // Create a ConnectionFactory
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("admin", "7Ta7uzbg", "failover:(tcp://119.3.10.221:61616)?timeout=3000");

            ActiveMQPrefetchPolicy test=new ActiveMQPrefetchPolicy();
//            test.setQueueBrowserPrefetch();
//            test.setQueuePrefetch();
            test.setQueuePrefetch(0);
            connectionFactory.setPrefetchPolicy(test);
            // Create a Connection
//            Connection connection = connectionFactory.createConnection();
//
//            connection.setExceptionListener(exception -> log.info("出错了", exception));
//
//            // Create a Session
//            Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);

            // Create the destination (Topic or Queue)
//            Destination destination = session.createQueue("TEST.FOO.ZZ6");

            // Create a MessageConsumer from the Session to the Topic or Queue
            String x="tcp://0.0.0.0:61616?maximumConnections=1000&amp;wireFormat.maxFrameSize=104857600&amp;transport.defaultKeepAlive=90000&amp;allowLinkStealing=false&amp;transport.activeMQSubscriptionPrefetch=1000&amp;wireFormat.maxInactivityDuration=30000&amp;wireFormat.maxInactivityDurationInitalDelay=10000&amp;transport.useInactivityMonitor=true&amp;transport.useKeepAlive=true";
            SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
            container.setConnectionFactory(connectionFactory);
            container.setDestination(new ActiveMQQueue("test.test.test3"));
            container.setSessionAcknowledgeMode(2);
            /**
             * 持久订阅参数
             */
//            container.setSubscriptionDurable(true);
//            container.setClientId("testzz");
            container.setMessageListener(new MessageListener() {
                int count = 0;

                @Override
                public void onMessage(Message message) {
                    ActiveMQTextMessage textMessage = (ActiveMQTextMessage) message;
                    try {
                        System.out.println(textMessage.getText());
                        System.out.println("testzz2看看会不会重发");
                        System.out.println(count++);
                    } catch (JMSException e) {
//                        e.printStackTrace();
                    }
                }
            });
            container.start();

//            // Wait for a message
//            Message message = consumer.receive(1000);
//
//            if (message instanceof TextMessage) {
//                TextMessage textMessage = (TextMessage) message;
//                String text = textMessage.getText();
//                System.err.println("Received: " + text);
//            } else {
//                System.err.println("Received: " + message);
//            }

//            consumer.close();
//            session.close();
//            connection.close();
        } catch (Exception e) {
            System.out.println("Caught: " + e);
            e.printStackTrace();
        }
    }
}
