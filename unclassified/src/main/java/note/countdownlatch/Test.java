package note.countdownlatch;

import sun.misc.Unsafe;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author AmazingZ
 * @date 2018/10/27 12:30
 */
public class Test{

    public static void main(String[] args) {

        ReentrantLock reentrantlock=new ReentrantLock();
        Condition condition=reentrantlock.newCondition();
        Unsafe unsafe=Unsafe.getUnsafe();


       Thread t= new Thread(new Runnable() {
            @Override
            public void run() {
                while (true)
                {
                    System.out.println("Hello World !");
                }
            }
        });
       t.setDaemon(false);
       t.start();
    }
}
