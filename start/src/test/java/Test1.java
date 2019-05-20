import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.locks.Lock;

import static com.sun.xml.internal.fastinfoset.util.ValueArray.MAXIMUM_CAPACITY;

/**
 * @author AmazingZ
 * @date 2019/4/16 10:55
 */
public class Test1 {

    class ThreadObj extends Thread {
        @Override
        public void run() {
            try {
                testSynMethod();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private final String lockObj = "lockMe";

    private void testSynMethod() throws InterruptedException {
        /**
         * 同步锁代码块抛出异常也是会释放锁的
         */
        synchronized (lockObj) {
            System.out.println(Thread.currentThread().getName());
            //确保两个另一线程也进入了此方法
            Thread.sleep(10000);
        }
    }

    private static void sayHello(Lock lock) throws InterruptedException {
        lock.lock();
        try {

        } finally {
            lock.unlock();
        }


        System.out.println("hello world");
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= 1 << 30) ? MAXIMUM_CAPACITY : n + 1;
    }

    static int[] quickSorted(int[] array, int l, int r) {
        int i = l;
        int j = r;
        int tem = array[l];
        if (i >= j) return array ;
        while (i < j) {
            while (i < j && tem <= array[j]) {
                j--;
            }
            array[i] = array[j];
            while (i < j && array[i] <= tem) {
                i++;
            }
            array[j] = array[i];
        }
        array[i] = tem;
        quickSorted(array, l, i - 1);
        quickSorted(array, i + 1, r);
        return array;
    }
    private static void quicksort(int[] array, int p, int r) {
        if (p < r) {
            final int q = partition(array, p, r);
            quicksort(array, p, q);
            quicksort(array, q + 1, r);
        }
    }

    private static int partition(int[] array, int p, int r) {
        final int x = array[(p + r) >>> 1];
        int i = p-1 ; int j = r+1 ;

        while (true) {
            while (x < array[--j]);
            while (x > array[++i]);
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
            else {
                return j;
            }
        }
    }

    public static void main(String[] args) {


        IntegerArray integerArrays = new IntegerArray(new int[]{5, 7, 9, 6, 3, 4, 7, 5, 3, 11});
        integerArrays.sort();
        int []test=new int[integerArrays.toIntArray().length]; ;
        System.arraycopy(integerArrays.toIntArray(),0,test,0,integerArrays.toIntArray().length);
        quicksort(test, 0, 9);
        integerArrays.sort();


        Object object= Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{Test1.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return null;
            }
        });
        FileChannel fileChannel = null;
        SocketChannel socketChannel = null;
        try {
            Selector selector = Selector.open();
            if (socketChannel != null) {
                socketChannel.register(selector, SelectionKey.OP_ACCEPT);
            }
            Set<SelectionKey> sets = selector.keys();
            Iterator<SelectionKey> keyIterator = sets.iterator();
            while (keyIterator.hasNext()) {
                SelectionKey key = keyIterator.next();
                if (key.isAcceptable()) {
                    // a connection was accepted by a ServerSocketChannel.
                } else if (key.isConnectable()) {
                    // a connection was established with a remote server.
                } else if (key.isReadable()) {
                    // a channel is ready for reading
                } else if (key.isWritable()) {
                    // a channel is ready for writing
                }
                keyIterator.remove();
            }

            fileChannel = FileChannel.open(Paths.get("C:\\Users\\zhutao14\\Desktop\\soapui.log"));

        } catch (IOException e) {
            e.printStackTrace();
        }
//
//        Runtime.getRuntime().addShutdownHook(new Thread(()->{
//
//            System.out.println("hello world");
//        }));
//        System.out.println("didi");
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                ThreadLocal<String> threadLocal1=new ThreadLocal<>();
//                threadLocal1.set("123");
//                ThreadLocal<String> threadLocal2=new ThreadLocal<>();
//                threadLocal2.set("456");
//                System.out.println(threadLocal1.get());
//                System.out.println(threadLocal2.get());
//            }
//        }).start();


//        String x = "zzsadsadzz";
//        int zz = x.hashCode();
//        int y = (zz >>> 16 ^ zz) & 63;
//
//        boolean asd = (zz % 32) == (zz & 31);
//
//        String z = Integer.toBinaryString(x.hashCode());
//
//        tableSizeFor(4);


//        Test1 m = new Test1();
//        Test1.ThreadObj t1 = m.new ThreadObj();
//        t1.setName("thread1");
//        Test1.ThreadObj t2 = m.new ThreadObj();
//        t2.setName("thread2");
//        t1.start();
//        t2.start();
//        Lock lock = new ReentrantLock();
//        new Thread(() -> {
//            lock.lock();
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } finally {
//                lock.unlock();
//                System.out.println("i'm over");
//            }
//        }).start();
//        Thread t3 = new Thread(() -> {
//            try {
//                sayHello(lock);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        t3.start();
//        t3.interrupt();


    }
}
