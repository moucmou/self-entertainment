import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author AmazingZ
 * @date 2019/4/29 16:34
 */
public class TestFor {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<500;i++){
            list.add(i);
        }
        new Thread(()->{
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Iterator<Integer> iterator=list.iterator();
            System.out.println("我执行了");
            while(iterator.hasNext()){
                if(iterator.next()==25){
                    iterator.remove();
                }
            }

        }).start();
        new Thread(()->{
            for (int x : list) {
                System.out.println(x);
            }
        }).start();
    }
}
