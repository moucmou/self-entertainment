package chain;

/**
 * @author AmazingZ
 * @date 2019/8/7 18:28
 */
public class Son extends Father {
     {
        System.out.println("我是子类非静态代码块");
    }
    static private int x =3;
   static  {
        System.out.println("我是子类静态代码块");
    }
    public Son(){
        System.out.println("我是子类构造方法");
    }
}
