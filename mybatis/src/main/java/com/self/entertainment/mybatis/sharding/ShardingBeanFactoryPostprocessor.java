package com.self.entertainment.mybatis.sharding;

import io.shardingsphere.shardingjdbc.jdbc.core.datasource.ShardingDataSource;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @author AmazingZ
 * @date 2019/7/26 11:16
 */
@Component
public class ShardingBeanFactoryPostprocessor implements BeanFactoryPostProcessor {


    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition shardingDataSource=  beanFactory.getBeanDefinition("dataSource");
//        shardingDataSource.getShardingContext().getShardingProperties().getProps().setProperty("sql.show", String.valueOf(Boolean.TRUE));
    }
}
