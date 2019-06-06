package chain.dubbo;

/**
 * @author AmazingZ
 * @date 2019/6/6 13:39
 */
public interface Filter {

    int invoke(Invoker invoker);
}
