package com.example.amq;

import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.jms.listener.SimpleMessageListenerContainer;
import org.springframework.jms.listener.adapter.MessageListenerAdapter;

import javax.jms.*;

/**
 * @author AmazingZ
 * @date 2019/6/27 16:23
 */
@Slf4j
public class AmqListener {

    public static void main(String[] args) {

        try {
            // Create a ConnectionFactory
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("admin", "7Ta7uzbg", "failover:(tcp://10.19.132.205:7018)?timeout=3000");
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

            SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
            container.setConnectionFactory(connectionFactory);
            container.setDestination(new ActiveMQQueue("test.test.test"));

            container.setSessionAcknowledgeMode(2);
            container.setMessageListener(new MessageListener() {

                @Override
                public void onMessage(Message message) {
                    TextMessage textMessage = (TextMessage) message;
                    try {
                        System.out.println(textMessage.getText());
//                        throw new RuntimeException("");
                    } catch (JMSException e) {
                        e.printStackTrace();
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
