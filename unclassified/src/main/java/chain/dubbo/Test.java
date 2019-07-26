package chain.dubbo;

import java.util.Arrays;
import java.util.List;

/**
 * @author AmazingZ
 * @date 2019/6/6 13:43
 */
public class Test {


    public static void main(String[] args) {
        List<Filter> filters = Arrays.asList(new Filter1(), new Filter2());
        Invoker last = new Invoker() {
            @Override
            public int invoke() {
                System.out.println("我是最后执行的");
                return 0;
            }
        };
        for (int i = filters.size() - 1; i >= 0; i--) {
            // 获取filter
            final Filter filter = filters.get(i);
            final Invoker next = last;
            final int x = i;
            // 更新last
            last = new Invoker() {
                @Override
                public int invoke() {
                    System.out.println("我关联的是第" + x + "invoker");
                    return filter.invoke(next);
                }
            };
        }
        last.invoke();
    }


}
