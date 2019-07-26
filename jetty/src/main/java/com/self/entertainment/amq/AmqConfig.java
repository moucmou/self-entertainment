package com.self.entertainment.amq;


import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.SimpleMessageListenerContainer;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

import javax.jms.*;
@Component
public class AmqConfig {

    @Autowired
    JmsTemplate jmsTemplate;

    public void sayHello(){
        jmsTemplate.send(new ActiveMQTopic("test.test.test"), new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {

                TextMessage textMessage= session.createTextMessage("test");
                return textMessage;
            }
        });
    }
}
