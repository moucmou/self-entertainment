package chain.dubbo;

import lombok.extern.slf4j.Slf4j;

/**
 * @author AmazingZ
 * @date 2019/6/6 13:41
 */
@Slf4j
public class Filter2 implements Filter {
    @Override
    public int invoke(Invoker invoker) {
        log.info("我是第二个filter");
        return invoker.invoke();
    }
}
