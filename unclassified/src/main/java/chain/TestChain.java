package chain;

import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ChainBase;
import org.apache.commons.chain.impl.ContextBase;

/**
 * @author AmazingZ
 * @date 2019/6/6 10:52
 */
public class TestChain extends ChainBase {


    public TestChain() {
        addCommand(new ApacheFilter());
        addCommand(new UserCommond());
        addCommand(new UserCommond1());

    }

    public static void main(String[] args) {
        Context context = new ContextBase();
        ChainBase chainBase = new TestChain();
        try {
            chainBase.execute(context);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
