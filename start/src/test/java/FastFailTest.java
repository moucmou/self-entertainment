import java.util.ArrayList;
import java.util.List;

/**
 * @author AmazingZ
 * @date 2019/4/29 15:16
 */
public class FastFailTest {

    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<50;i++){
            list.add(i);
        }
        for(int x :list){
            if(x==20){
                list.remove(x);
            }
        }
//        new Thread(()->{
//            for(int x:list){
//                System.out.println(x);
//            }
//        }).start();
//        new Thread(()->{
//            System.out.println("我执行了");
//            list.remove(14);
//        }).start();
    }
}
