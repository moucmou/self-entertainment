package cn.example.amazingt.service;

import cn.example.amazingt.note.spinlocks.Spinlocks;

/**
 * @author AmazingZ
 * @date 2018/10/19 18:23
 */
public class SpinlocksTest {
    public static void main(String[] args) {

//         AtomicReference<String > cas = new AtomicReference<>();
////        boolean x= cas.compareAndSet("111","111");
//        StringBuffer stringBuffer=new StringBuffer();
//        stringBuffer.append("xxxx");
//        boolean y= cas.compareAndSet(null,"xxx");
//        boolean z= cas.compareAndSet("xxx","123");
        Spinlocks spinLock=new Spinlocks();

        new Thread(new Runnable() {
            @Override
            public void run() {
//                System.out.println("hello");
                get();
                set();
            }

            void get(){
                spinLock.lock();
                System.out.println("hello");
            }
            void set(){
                spinLock.lock();
                System.out.println("hello");
            }
        }).start();

//        new Thread(new Runnable() {
//
//            @Override
//            public void run() {
////                System.out.println("hello");
//                get();
//            }
//
//             void get(){
//                spinLock.lock();
//                System.out.println("hello");
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                get();
//            }
//
//             void get(){
//                spinLock.lock();
//                System.out.println("hello");
//
//            }
//        }).start();
    }

}
