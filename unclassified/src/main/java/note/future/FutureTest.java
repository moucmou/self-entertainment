package note.future;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author AmazingZ
 * @date 2019/7/22 17:08
 */
@Slf4j
public class FutureTest {

    private static ExecutorService executors = Executors.newCachedThreadPool();
    private static Map<String, Thread> map = new HashMap<>();
    private static BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
//        lock.lock();


        new Thread(() -> {
            try {
                lock.lock();
                System.out.println("拿到锁了睡会儿");
                Thread.sleep(10000);
                lock.unlock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        Thread.sleep(1000);
        Thread t1 = new Thread(() -> {
            System.out.println("我进来了吗");
//            try {
//                queue.take();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            lock.lock();
//            try {
//                lock.lockInterruptibly();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            if(!Thread.currentThread().isInterrupted()){
            System.out.println("我会做这件事情吗，不会了吧");
            lock.unlock();
//            }

        });

        t1.start();
        Thread.sleep(1000);
        t1.interrupt();
        new Thread(() -> {
            lock.lock();
            System.out.println("我是新来的线程，我也会比之前被打断的线程先执行，因为我是被唤醒的，我会插到头节点后面");
            lock.unlock();
        }).start();
//        map.putIfAbsent("main",Thread.currentThread());
//        LockSupport.park();
        System.out.println("主线程执行结束");
//        Future<ResultClass> future = executors.submit(new FutureTEst());
//
//        try {
//            new Thread(()->{
//                future.cancel(true);
//            }).start();
//            ResultClass resultClass = future.get();
//
//            log.info(resultClass.dnmd);
//        } catch (InterruptedException | ExecutionException |CancellationException e) {
//            e.printStackTrace();
//        }
    }

    public static class ResultClass {
        private String dnmd;

        public ResultClass(String dnmd) {
            this.dnmd = dnmd;
        }
    }

    public static class FutureTEst implements Callable<ResultClass> {

        @Override
        public ResultClass call() throws Exception {
            Thread.sleep(5000);
            return new ResultClass("dnmd");
        }
    }
}
