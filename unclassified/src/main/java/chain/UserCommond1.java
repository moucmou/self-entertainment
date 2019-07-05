package chain;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

/**
 * @author AmazingZ
 * @date 2019/6/6 10:51
 */
@Slf4j
public class UserCommond1 implements Command {
    @Override
    public boolean execute(Context context) throws Exception {

        log.info("我被执行了  1");
        return false;
    }
}
