package note.Interceptor;

import java.lang.reflect.Method;

/**
 * @author AmazingZ
 * @date 2018/10/26 15:48
 */
public interface Interceptor {

    boolean before(Object proxy, Object target, Method method, Object[] args);

    void around(Object proxy, Object target, Method method, Object[] args);

    void after(Object proxy, Object target, Method method, Object[] args);
}
