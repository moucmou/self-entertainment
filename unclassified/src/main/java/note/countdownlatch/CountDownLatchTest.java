package note.countdownlatch;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author AmazingZ
 * @date 2018/10/27 11:52
 */
public class CountDownLatchTest {
    private final static CountDownLatch cdl = new CountDownLatch(2);
    private final static ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2, 15, 30, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());//使用线程池
    private final static Executor threadPoo1 = Executors.newFixedThreadPool(8);

    private static class GoThread extends Thread {
        private final String name;

        GoThread(String name) {
            this.name = name;

        }

        public void run() {
            System.out.println(name + "开始从宿舍出发");
//            cdl.countDown();
            try {
                Thread.sleep(1000);
//                cdl.await();//拦截线程
                System.out.println(name + "从楼底下出发");
                Thread.sleep(1000);
                System.out.println(name + "到达操场");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub
//        threadPool.allowCoreThreadTimeOut(true);
//        threadPool.execute(new Runnable() {
//            @Override
//            public void run() {
//                Thread.currentThread().setName("lisi");
//                System.out.println("111");
//            }
//        });
        Lock lock = new ReentrantLock();
//        threadPool.shutdown();;
        Thread t1 = new Thread(() -> {
            try {
                lock.lockInterruptibly();
                while (true) {
                    Thread.sleep(3 * 1000);
                    System.out.println("Hello World 11111");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        });
        Thread t2 = new Thread(() -> {
            lock.lock();
            while (true) {
                try {
                    Thread.sleep(3 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Hello World 22222");
            }


        });

        t1.start();
        t2.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t2.interrupt();


//
//        String[] str= {"李明","王强","刘凯","赵杰"};
//        String[] str1= {"王二","洪光","雷兵","赵三"};
//        for(int i=0;i<4;i++)
//        {
//            threadPool.execute(new GoThread(str[i]));
////            new GoThread(str[i]).start();
//        }
//        try
//        {
//            Thread.sleep(4000);
//            System.out.println("四个人一起到达球场，现在开始打球");
//            System.out.println("现在对CyclicBarrier进行复用.....");
//            System.out.println("又来了一拨人，看看愿不愿意一起打：");
//        }
//        catch(InterruptedException e)
//        {
//            e.printStackTrace();
//        }
//        for(int i=0;i<4;i++)
//        {
//            threadPool.execute(new GoThread(str1[i]));
////            new GoThread(str1[i]).start();
//        }
//        try
//        {
//            Thread.sleep(4000);
//            System.out.println("四个人一起到达球场，表示愿意一起打球，现在八个人开始打球");
//            //System.out.println("现在对CyclicBarrier进行复用");
//        }
//        catch(InterruptedException e)
//        {
//            e.printStackTrace();
//        }
//        threadPool.shutdown();
//        System.out.println("end");
////        threadPool.
//        for(int i=0;i<4;i++)
//        {
//            threadPool.execute(new GoThread(str1[i]));
////            new GoThread(str1[i]).start();
//        }


    }


}
