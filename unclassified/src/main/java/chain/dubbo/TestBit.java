package chain.dubbo;

import lombok.extern.slf4j.Slf4j;

import java.util.BitSet;

/**
 * @author AmazingZ
 * @date 2019/6/10 15:06
 */
@Slf4j
public class TestBit {

    public static void main(String[] args) {
        BitSet bitSet1 = BitSet.valueOf(new long[]{99, 123, 55});
        BitSet bitSet = new BitSet();
        bitSet.set(66);
        bitSet.set(88);
        System.out.println();
    }
}
