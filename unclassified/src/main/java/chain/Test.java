package chain;

/**
 * @author AmazingZ
 * @date 2019/6/6 11:57
 */
public class Test {
    public static class Test1 {

    }

    public static void main(String[] args) {


        Test1 last = new Test1();
        for (int i = 0; i < 5; i++) {
            Test1 next = last;
            last = new Test1();
        }
        System.out.println();

    }
}
