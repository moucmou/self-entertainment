package cn.example.amazingt.note.jdkproxy;

/**
 * @author AmazingZ
 * @date 2018/10/26 15:31
 */
public class JdkProxyExampleTest {
    public static void main(String[] args) {
        JdkProxyExample jdk = new JdkProxyExample();
        ((HelloWorld) jdk.bind(new HelloWorldImpl())).sayHelloWorld();
    }
}
