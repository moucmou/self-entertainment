package com.self.entertainment.unclassified;

import org.apache.dubbo.rpc.*;
import org.apache.dubbo.rpc.listener.InvokerListenerAdapter;

/**
 * @author AmazingZ
 * @date 2019/7/4 16:48
 */
public class InvokerListenertest extends InvokerListenerAdapter {

    @Override
    public void referred(Invoker<?> invoker) throws RpcException {
    }

    @Override
    public void destroyed(Invoker<?> invoker) {

    }
}
