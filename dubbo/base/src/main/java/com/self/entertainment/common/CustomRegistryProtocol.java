//package com.self.entertainment.common;
//
//import org.apache.dubbo.common.Constants;
//import org.apache.dubbo.common.URL;
//import org.apache.dubbo.common.utils.NetUtils;
//import org.apache.dubbo.registry.Registry;
//import org.apache.dubbo.registry.RegistryFactory;
//import org.apache.dubbo.registry.RegistryService;
//import org.apache.dubbo.registry.integration.RegistryDirectory;
//import org.apache.dubbo.registry.integration.RegistryProtocol;
//import org.apache.dubbo.rpc.*;
//import org.apache.dubbo.rpc.protocol.AbstractProtocol;
//
//import java.lang.reflect.Field;
//import java.util.List;
//
///**
// * 完成了RegistryProtocol的代理和扩展 ,实现Protocol接口
// * <p>
// * 修正RegistryProtocol协议过程中，refer在创建后立马调用过程中无法定位到server的问题
// *
// * @author nihaifeng
// *
// */
//public class CustomRegistryProtocol extends AbstractProtocol {
//	private RegistryProtocol target;
//	private Protocol protocol;
//	private RegistryFactory registryFactory;
//	private ProxyFactory proxyFactory;
//
//	public CustomRegistryProtocol(RegistryProtocol target) throws Exception {
//		super();
//		this.target = target;
//		Class<?> clazz = RegistryProtocol.class;
//		this.protocol = (Protocol) getField(target, clazz, "protocol");
//		this.registryFactory = (RegistryFactory) getField(target, clazz, "registryFactory");
//		this.proxyFactory = (ProxyFactory) getField(target, clazz, "proxyFactory");
//	}
//
//	public final static Object getField(Object obj, Class<?> clazz, String name) throws Exception {
//		Field field = clazz.getDeclaredField(name);
//		field.setAccessible(true);
//		return field.get(obj);
//	}
//
//	@Override
//	public <T> Exporter<T> export(final Invoker<T> originInvoker) throws RpcException {
//		return target.export(originInvoker);
//	}
//
//
//
//	@SuppressWarnings("unchecked")
//	@Override
//	public <T> Invoker<T> refer(Class<T> type, URL url) throws RpcException {//修正refer在创建后立马调用过程中无法定位到server的问题
//		URL newurl = url.setProtocol(url.getParameter(Constants.REGISTRY_KEY, Constants.DEFAULT_REGISTRY)).removeParameter(Constants.REGISTRY_KEY);
//		Registry registry = registryFactory.getRegistry(newurl);
//		if (RegistryService.class.equals(type)) {
//			return proxyFactory.getInvoker((T) registry, type, newurl);
//		}
//		RegistryDirectory<T> directory = new RegistryDirectory<T>(type, newurl);
//		directory.setRegistry(registry);
//		directory.setProtocol(protocol);
//		URL subscribeUrl = new URL(Constants.CONSUMER_PROTOCOL, NetUtils.getLocalHost(), 0, type.getName(), directory.getUrl().getParameters());
//		subscribeUrl = subscribeUrl.addParameter(Constants.CATEGORY_KEY, Constants.PROVIDERS_CATEGORY + "," + Constants.CONFIGURATORS_CATEGORY + "," + Constants.ROUTERS_CATEGORY);
//		Invoker<T> result = target.refer(type, url);
//		List<URL> list = registry.lookup(subscribeUrl);
//		directory.notify(list);
//		return result;
//
//	}
//
//	@Override
//	public void destroy() {
//		target.destroy();
//	}
//
//	@Override
//	public int getDefaultPort() {
//		return target.getDefaultPort();
//	}
//
//}