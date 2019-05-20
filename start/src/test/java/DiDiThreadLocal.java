/**
 * @author AmazingZ
 * @date 2019/4/29 11:00
 */
public class DiDiThreadLocal {

    public static void main(String[] args) {
        Thread t2=new Thread(()->{
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("i'm service");
        });
       Thread t=  new Thread(()->{
            ThreadLocal<String> threadLocal=new ThreadLocal<>();
            ThreadLocal<String> threadLocal2=new ThreadLocal<>();
            threadLocal.set("didi");
            threadLocal2.set("didi2");
            System.out.println(threadLocal.get());
            System.out.println(threadLocal2.get());
//           try {
//               Thread.sleep(5000);
//           } catch (InterruptedException e) {
//               e.printStackTrace();
//           }
           t2.start();
           try {
               t2.join();
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           System.out.println("service");
           System.out.println("i'm done");
       });
        t.start();
        System.out.println();

    }
}
