/**
 * @author AmazingZ
 * @date 2019/5/7 13:55
 */
public class TestException {

    public static String fun(){

        try{
            return "return";
        }finally {
            return "finally";
        }
    }
    public static void main(String[] args) {

        String y= fun();

        try{
            int x=1/0;
        }catch (Exception e ){
            System.out.println(e);
            System.out.println(e.getMessage());
        }
    }
}
