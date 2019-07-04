package com.self.entertainment.config;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.registry.Registry;
import org.apache.dubbo.registry.support.AbstractRegistryFactory;

public class SimpleRegistryFactory extends AbstractRegistryFactory {

    @Override
    protected Registry createRegistry(URL url) {

        return SimpleRegistryService.getInstance();
    }

}
