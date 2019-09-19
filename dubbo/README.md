前置知识
1.上来先一通堆栈调试要我命
```
/**
在这就拿到了实现对应协议的装饰器  要求装饰器的构造方法参数为包装的对应接口，并且写到对应接口的META-INF目录下，就能实现装饰者本身的意义
*/
cacheWrapperClass:808, ExtensionLoader (org.apache.dubbo.common.extension)
loadClass:726, ExtensionLoader (org.apache.dubbo.common.extension)
loadResource:702, ExtensionLoader (org.apache.dubbo.common.extension)
loadDirectory:674, ExtensionLoader (org.apache.dubbo.common.extension)
loadExtensionClasses:636, ExtensionLoader (org.apache.dubbo.common.extension)
getExtensionClasses:619, ExtensionLoader (org.apache.dubbo.common.extension)
createExtension:521, ExtensionLoader (org.apache.dubbo.common.extension)
getExtension:347, ExtensionLoader (org.apache.dubbo.common.extension)
main:14, TestDubbo (com.self.entertainment.unclassified)
```
2. 想要弄清楚protocolistenerWrapper的原理，
其实就是装饰着模式层层包装，然后调用一个方法的时候就会去调用其里层的对象就会把这几个wrapper都执行了

3.根据协议名字拼出来的代码执行其对应的Factory    //需要整理一下extensionLoader的源码了
```
package org.apache.dubbo.registry;
import org.apache.dubbo.common.extension.ExtensionLoader;
public class RegistryFactory$Adaptive implements org.apache.dubbo.registry.RegistryFactory {
public org.apache.dubbo.registry.Registry getRegistry(org.apache.dubbo.common.URL arg0)  {
if (arg0 == null) throw new IllegalArgumentException("url == null");
org.apache.dubbo.common.URL url = arg0;
String extName = ( url.getProtocol() == null ? "dubbo" : url.getProtocol() );
if(extName == null) throw new IllegalStateException("Failed to get extension (org.apache.dubbo.registry.RegistryFactory) name from url (" + url.toString() + ") use keys([protocol])");
org.apache.dubbo.registry.RegistryFactory extension = (org.apache.dubbo.registry.RegistryFactory)ExtensionLoader.getExtensionLoader(org.apache.dubbo.registry.RegistryFactory.class).getExtension(extName);
return extension.getRegistry(arg0);
}
}
```
4.消费者在启动的时候会把自己也注册到服务器并监听对应节点下的生产者  ？？
```
register:41, SimpleRegistryService (com.self.entertainment.config)
register:44, AbstractRegistryService (com.self.entertainment.config)
//在这会向注册中心注册自己的服务
doRefer:383, RegistryProtocol (org.apache.dubbo.registry.integration)
refer:367, RegistryProtocol (org.apache.dubbo.registry.integration)
//用装饰着模式封装的过滤器？反正在执行到真正的refer方法之前这个这几个类的refer方法都会被执行
refer:70, QosProtocolWrapper (org.apache.dubbo.qos.protocol)
refer:114, ProtocolFilterWrapper (org.apache.dubbo.rpc.protocol)
refer:65, ProtocolListenerWrapper (org.apache.dubbo.rpc.protocol)
refer:82, CustomProtocolListenerWrapper (com.self.entertainment.common)
refer:65, ProtocolListenerWrapper (org.apache.dubbo.rpc.protocol)
refer:-1, Protocol$Adaptive (org.apache.dubbo.rpc)
//在这会根据url的头协议取出其对应的实现即RegistryProtocol 会为每个消费者进行封装代理
createProxy:366, ReferenceConfig (org.apache.dubbo.config)
init:305, ReferenceConfig (org.apache.dubbo.config)
get:231, ReferenceConfig (org.apache.dubbo.config)
getObject:71, ReferenceBean (org.apache.dubbo.config.spring)
```
5.无意间发现了一个apache timer的实现类HashedWheelTimer，可以做一次失败过后不断尝试做某件事情的功能
6.regidtryprotocol refer 生成一个RegistryDirectory，将订阅的url在RegistryDirectory内部转换成Invoker
7.ReferenceBean在被依赖的时候由于实现了factorybean会调用get()进而走到代理过程
```
getProxy:66, StubProxyFactoryWrapper (org.apache.dubbo.rpc.proxy.wrapper)
getProxy:-1, ProxyFactory$Adaptive (org.apache.dubbo.rpc)
createProxy:405, ReferenceConfig (org.apache.dubbo.config)
init:305, ReferenceConfig (org.apache.dubbo.config)
get:231, ReferenceConfig (org.apache.dubbo.config)
```
返回一个长成这个样子的url，使用JavassistProxyFactory生成一个代理为实例的接口进行代理
```
invoker :interface com.self.entertainment.TestRestEasyService -> 
simple://127.0.0.1:8073/server@justTest?application=demo-
consumer&check=false&default.lazy=false&default.sticky=false&dubbo=2.0.2&interface=server@justTest&
lazy=false&methods=echo&pid=14932&register.ip=169.254.56.35&release=2.7.1&side=consumer&sticky=
false&timestamp=1562324452404,directory: 
org.apache.dubbo.registry.integration.RegistryDirectory@430afce5
```
8.调用的时候再将参数和方法生成RpcInvocation 远程调用代理，同样会到MockClusterInvoker这里调用invoke方法后进去为生成的这个RpcInvocation选择一个真正的url进行远程调用