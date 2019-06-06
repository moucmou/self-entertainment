package chain;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author AmazingZ
 * @date 2019/6/6 17:24
 *
 * mybatis 实现责任链的方式
 */
@Slf4j
public class MybatisFilter {

    public interface TestGG{
        String sayHello(String x);
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

       Object object1= Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{TestGG.class},
               (proxy, method, args1) -> {
                   TestGG testGG=new TestGG() {
                       @Override
                       public String sayHello(String x) {
                           return x;
                       }
                   };
                   log.info("我被执行了一次");
                   return method.invoke(testGG, args1);
               });

        Object object2=   Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{TestGG.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                log.info("我被执行了第二次");
                return method.invoke(object1,args);
            }
        });
        System.out.println();

//        TestGG testGG= (TestGG)object;
        Method method= Arrays.asList( TestGG.class.getMethods())  .get(0);
        method.invoke(object2,"12313");
    }
}
