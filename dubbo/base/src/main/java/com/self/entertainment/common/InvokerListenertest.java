package com.self.entertainment.common;

import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.RpcException;
import org.apache.dubbo.rpc.listener.InvokerListenerAdapter;

/**
 * @author AmazingZ
 * @date 2019/7/4 16:48
 */
public class InvokerListenertest extends InvokerListenerAdapter {

    @Override
    public void referred(Invoker<?> invoker) throws RpcException {
        System.out.println();
    }

    @Override
    public void destroyed(Invoker<?> invoker) {
        System.out.println();

    }
}
