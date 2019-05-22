package cn.example.amazingt.util;

import cn.example.amazingt.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author AmazingZ
 * @date 2018/9/16 19:03
 */
@Order(1)
@WebFilter(urlPatterns = "/*", filterName = "webFilter")
public class HttpFilter implements Filter {

    Logger logger = LoggerFactory.getLogger(HttpFilter.class);
    private static ThreadLocal<String> ipInNote = new ThreadLocal<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession();
        ;

        if (null != session.getAttribute("user")) {
            User user = (User) session.getAttribute("user");
            session.setAttribute("remoteUser", user.getUserName());
            if (null == ipInNote.get()) {
                String ip = this.getIpAddr(httpRequest);
                ipInNote.set(ip);
                logger.info("当前登录用户" + user.getUserName() + "的ip为" + ip);
            }
        }
        chain.doFilter(request, response);

    }

    @Override
    public void destroy() {

    }

    /**
     * 获取真实的请求IP地址
     *
     * @param request HttpServletRequest对象
     * @return
     * @author hanpanpan. 2017年11月13日 下午1:41:37
     */
    private String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
