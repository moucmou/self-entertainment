package com.feign.client;

import com.feign.custom.CustomeConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

/**
 * @author: zhutao
 * @date: 2020/10/21 10:22 上午
 */
@RibbonClients(defaultConfiguration = CustomeConfiguration.class)
public class RibbonConfiguration {

}
