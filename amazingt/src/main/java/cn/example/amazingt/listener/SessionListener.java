package cn.example.amazingt.listener;

import cn.example.amazingt.entity.User;
import cn.example.amazingt.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.*;

/**
 * @author AmazingZ
 * @date 2018/9/16 15:38
 */

@WebListener
public class SessionListener implements HttpSessionListener, ServletRequestListener, HttpSessionAttributeListener {

    static final Logger logger = LoggerFactory.getLogger(SessionListener.class);
    static Set<String> nameSet = Collections.synchronizedSet(new HashSet<>());

    public static Set<String> getNameSet() {
        return nameSet;
    }


    public SessionListener() {
        super();

        logger.info("SessionListenerInitialized");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        logger.info("sessionCreated");
        ServletContext context = se.getSession().getServletContext();
        if (StringUtils.isEmpty(context.getAttribute("currentCount"))) {
            context.setAttribute("currentCount", 1);
            return;
        }
        context.setAttribute("currentCount", Integer.valueOf(context.getAttribute("currentCount").toString()) + 1);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        logger.info("sessionDestroyed");
        ServletContext context = se.getSession().getServletContext();
        if (StringUtils.isEmpty(context.getAttribute("currentCount"))) {
            context.setAttribute("currentCount", 0);
            return;
        }
        context.setAttribute("currentCount", (Integer.valueOf(context.getAttribute("currentCount").toString()) - 1) < 1
                ? 0 : Integer.valueOf(context.getAttribute("currentCount").toString()));

    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        logger.info("requestDestroyed" + sre.toString());
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        logger.info("requestInitialized" + sre.toString());
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        logger.info("requestInitialized" + se.toString());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        logger.info("attributeRemoved" + se.toString());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
        logger.info("attributeReplaced" + se.toString());
    }
}
