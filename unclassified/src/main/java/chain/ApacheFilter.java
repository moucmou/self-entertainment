package chain;

import org.apache.commons.chain.Context;
import org.apache.commons.chain.Filter;

/**
 * @author AmazingZ
 * @date 2019/7/5 16:20
 */
public class ApacheFilter implements Filter {
    @Override
    public boolean postprocess(Context context, Exception exception) {
        System.out.println("我是前置拦截器");
        return false;
    }

    @Override
    public boolean execute(Context context) throws Exception {
        System.out.println("filter中的拦截器");
        return false;
    }
}
