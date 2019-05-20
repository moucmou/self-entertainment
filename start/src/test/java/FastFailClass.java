import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author AmazingZ
 * @date 2019/4/29 16:28
 */
public class FastFailClass {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList();

        for(int i = 0; i < 50; ++i) {
            list.add(i);
        }

        Iterator var4 = list.iterator();

        while(var4.hasNext()) {
            int x = (Integer)var4.next();
            if (x == 20) {
                list.remove(x);
            }
        }
    }
}
