package com.self.entertainment.amq;


import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

@Configuration
public class ConfigAmq {

    @Autowired
    MessageListener messageListener;
    @Bean
    public ActiveMQTopic activeMQTopic(){
      return   new ActiveMQTopic("test.test.test");
    }
    @Bean
    public DefaultMessageListenerContainer defaultMessageListenerContainer(CachingConnectionFactory cachingConnectionFactory){

        DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
        container.setConnectionFactory(cachingConnectionFactory);
        //监听queue
        container.setDestination(activeMQTopic());
        //监听topic
//		container.setDestination(topicDestination());
        container.setMessageListener(messageListener);
        container.setSessionAcknowledgeMode(2);
        return container;
    }
}
