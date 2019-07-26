package cn.example.amazingt.note.cglib;

/**
 * @author AmazingZ
 * @date 2018/10/26 15:41
 */
public class TestCglibProxy {


    public static void main(String[] args) {
        CglibProxyExample cpe = new CglibProxyExample();
        ReflectServiceImpl obj = (ReflectServiceImpl) cpe.getProxy(ReflectServiceImpl.class);
        obj.sayHello("张三");
    }

}
