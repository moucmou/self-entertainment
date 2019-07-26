package com.self.entertainment.amq;

import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

@Slf4j
@Component
public class MessageListener implements javax.jms.MessageListener
//        , InitializingBean
{
    @Override
    public void onMessage(Message message) {
        log.info(message.toString());
        if(message instanceof TextMessage){
            try {
                log.info(((TextMessage) message).getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }

        }
        try {
            message.acknowledge();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

//    @Override
//    public void afterPropertiesSet() throws Exception {
//        DefaultMessageListenerContainer defaultMessageListenerContainer=new DefaultMessageListenerContainer();
//        defaultMessageListenerContainer.setConnectionFactory(cachingConnectionFactory);
//        defaultMessageListenerContainer.setDestination(new ActiveMQTopic("test.test.test"));
//        defaultMessageListenerContainer.setMessageListener(this);
//        defaultMessageListenerContainer.start();
//    }
}
