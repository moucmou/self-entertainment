package chain.dubbo;

import lombok.extern.slf4j.Slf4j;

/**
 * @author AmazingZ
 * @date 2019/6/6 13:40
 */
@Slf4j
public class Filter1 implements Filter {
    @Override
    public int invoke(Invoker invoker) {
        log.info("我是第一个filter");
        return invoker.invoke();
    }
}
