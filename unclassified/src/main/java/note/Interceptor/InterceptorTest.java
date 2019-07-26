package note.Interceptor;

import note.jdkproxy.HelloWorld;
import note.jdkproxy.HelloWorldImpl;

/**
 * @author AmazingZ
 * @date 2018/10/26 16:03
 */
public class InterceptorTest {
    public static void main(String[] args) {
        HelloWorld proxy = (HelloWorld) InterceptorJdkProxy.bind(new HelloWorldImpl(),
                "cn.example.amazingt.note.Interceptor.MyInterceptor");
        proxy.sayHelloWorld();

    }
}
