package com.self.entertainment.common;

import org.apache.dubbo.common.Constants;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.utils.StringUtils;
import org.apache.dubbo.registry.integration.RegistryProtocol;
import org.apache.dubbo.rpc.Exporter;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.Protocol;
import org.apache.dubbo.rpc.RpcException;
import org.apache.dubbo.rpc.protocol.ProtocolListenerWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * @author AmazingZ
 * @date 2019/7/4 11:32
 */
public class CustomProtocolListenerWrapper extends ProtocolListenerWrapper {

    private static final Logger LOG = LoggerFactory.getLogger(CustomProtocolListenerWrapper.class);

//    private static Protocol doTransform(Protocol protocol) {
//        try {
//            Object regProtocol = protocol;
//            while (!(regProtocol instanceof RegistryProtocol)) {
//                Field protocolField = regProtocol.getClass().getDeclaredField("protocol");
//                protocolField.setAccessible(true);
//                regProtocol = protocolField.get(regProtocol);
//            }
//            CustomRegistryProtocol registryProtocol = new CustomRegistryProtocol((RegistryProtocol) regProtocol);
//            return new ProtocolListenerWrapper(registryProtocol);
//        } catch (Exception e) {
//            LOG.debug("dubbo Protocol ' protocol not find");
//        }
//        return protocol;
//    }



    public CustomProtocolListenerWrapper(Protocol protocol) {
        super(protocol);
//        super(doTransform(protocol));


    }

    public <T> Exporter<T> export(Invoker<T> invoker) throws RpcException {
        return super.export(invoker);
    }

    public <T> Invoker<T> refer(Class<T> type, URL url) throws RpcException {
        if (Constants.REGISTRY_PROTOCOL.equals(url.getProtocol()) && type.isAnnotationPresent(ServerType.class)) {
            String serverType = type.getAnnotation(ServerType.class).value();
            url = url.setPath("server@" + serverType);
            Map<String, String> map = StringUtils.parseQueryString(url.getParameterAndDecoded(Constants.REFER_KEY));
            map.put("interface", "server@" + serverType);
            url = url.addParameterAndEncoded(Constants.REFER_KEY, StringUtils.toQueryString(map));
        } else {
            String path = url.getPath();
            if (path != null && path.contains("server@")) {
                int index = path.indexOf("server@");
                url = url.setPath(path.substring(0, index));
            }
        }
        {//增加@Interceptor注解实现的功能完善
            Interceptor interceptor = type.getAnnotation(Interceptor.class);
            if (interceptor != null) {
                Class<?>[] classes = interceptor.interceptorClass();
                if (classes.length > 0) {
                    String[] extend = new String[classes.length];
                    for (int i = 0; i < classes.length; i++) {
                        extend[i] = classes[i].getName();
                    }
                    url = url.addParameter(Constants.EXTENSION_KEY, StringUtils.join(extend, ","));
                }
            }
        }
        return super.refer(type, url);
    }
}
