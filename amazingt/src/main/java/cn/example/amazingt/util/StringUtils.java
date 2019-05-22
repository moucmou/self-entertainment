package cn.example.amazingt.util;

/**
 * @author AmazingZ
 * @date 2018/9/15 15:32
 */
public class StringUtils  extends org.springframework.util.StringUtils{

    private final static String[] chars = new String[]{"%", "_"};

    /**
     * 拼接字符串
     * @author shaochunchao 2017年11月12日
     * @return
     */
    public static String splice(Object... objs) {
        if (objs == null) {
            return null;
        }
        StringBuilder builder = new StringBuilder();
        for (Object obj : objs) {
            builder.append(obj);
        }
        return builder.toString();
    }

}
