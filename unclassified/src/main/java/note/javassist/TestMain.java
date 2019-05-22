package note.javassist;

import javassist.*;
import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;
import javassist.util.proxy.ProxyObject;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;

/**
 * @author AmazingZ
 * @date 2019/5/22 17:27
 */
@Slf4j
public class TestMain {

    // 代理工厂创建动态代理
    public  static  void testJavassistFactoryProxy() throws Exception {
        // 创建代理工厂
        ProxyFactory proxyFactory = new ProxyFactory();

        // 设置被代理类的类型
        proxyFactory.setSuperclass(RayTest.class);

        // 创建代理类的class
        Class<?> proxyClass = proxyFactory.createClass();

        // 创建对象
        RayTest proxyTest = (RayTest)proxyClass.newInstance();

        ((ProxyObject) proxyTest).setHandler(new MethodHandler() {
            // 真实主题
            RayTest test = new RayTest();

            public Object invoke(Object self, Method thisMethod,
                                 Method proceed, Object[] args) throws Throwable {
                String before = "before ";
                Object str = thisMethod.invoke(test, args);
                String after = " after";
                return before + str + after;
            }
        });
         proxyTest.sayHello();
    }

    // 动态代码创建的例子
    // 下面例子使用 Javassist 的 API成功组织出代理类的一个子类，可以看出 添加构造函数，添加属性，
    // 添加方法，内容 都是通过字符串类型完成即可。 通过 Javassist 强大的字节生成能力可以达到动态
    // 增加类和实现动态代理的功能.
    public static void testJavassistDefineClass() throws Exception  {
        // 创建类池，true 表示使用默认路径
        ClassPool classPool = new ClassPool(true);

        // 创建一个类 RayTestJavassistProxy
        CtClass ctClass = classPool.makeClass(RayTest.class.getName() + "JavassistProxy");

        // 添加超类
        // 设置 RayTestJavassistProxy 的父类是 RayTest.
        ctClass.setSuperclass(classPool.get(RayTest.class.getName()));

        // 添加默认构造函数
        ctClass.addConstructor(CtNewConstructor.defaultConstructor(ctClass));

        // 添加属性
        ctClass.addField(CtField.make("public " + RayTest.class.getName() + " real = new " +
                RayTest.class.getName() + "();", ctClass));

        // 添加一个额外的方法
        ctClass.addMethod(CtMethod.make("public String sayFuck() { return \"fuck!!\";}",
                ctClass));
        Class<?> testClass = ctClass.toClass();
        /**
         * 创建实例
         */
        Object object= testClass.newInstance();
        /**
         * 反射执行方法
         */
        Method m = testClass.getDeclaredMethod("sayFuck");

        log.info(String.valueOf(m.invoke(object)) );
    }

    public static void main(String[] args) throws Exception {
        testJavassistDefineClass();
    }
}
