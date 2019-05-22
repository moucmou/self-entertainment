package note.spinlocks;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author AmazingZ
 * @date 2018/10/19 18:22
 */
public class Spinlocks {

    private AtomicReference<Thread> cas = new AtomicReference<Thread>();
    public void lock() {
        Thread current = Thread.currentThread();
        // 利用CAS
        while (!cas.compareAndSet(null, current)) {
            // DO nothing
        }
    }
    public void unlock() {
        Thread current = Thread.currentThread();
        cas.compareAndSet(current, null);
    }

    private AtomicReference<Thread> owner =new AtomicReference<>();
    private int count =0;
    public void lock1(){
        Thread current = Thread.currentThread();
        if(current==owner.get()) {
            count++;
            return ;
        }

        while(!owner.compareAndSet(null, current)){

        }
    }
    public void unlock1 (){
        Thread current = Thread.currentThread();
        if(current==owner.get()){
            if(count!=0){
                count--;
            }else{
                owner.compareAndSet(current, null);
            }

        }

    }
}
