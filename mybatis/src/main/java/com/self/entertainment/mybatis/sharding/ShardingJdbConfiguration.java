package com.self.entertainment.mybatis.sharding;

import io.shardingsphere.api.config.rule.ShardingRuleConfiguration;
import io.shardingsphere.api.config.rule.TableRuleConfiguration;
import io.shardingsphere.core.constant.properties.ShardingPropertiesConstant;
import io.shardingsphere.core.rule.TableRule;
import io.shardingsphere.shardingjdbc.jdbc.core.datasource.ShardingDataSource;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * @author AmazingZ
 * @date 2019/7/18 15:14
 */
//@Configuration
//@AutoConfigureAfter(SpringBootConfiguration.class)
@Component
public class ShardingJdbConfiguration implements BeanPostProcessor {


    @Nullable
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ShardingDataSource) {
            ShardingDataSource shardingDataSource = (ShardingDataSource) bean;
            shardingDataSource.getShardingContext().getShardingProperties().getProps().setProperty("sql.show", String.valueOf(Boolean.TRUE));
        }
        return bean;
    }
}
