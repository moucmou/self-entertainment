package com.self.entertainment.unclassified;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.*;

/**
 * @author AmazingZ
 * @date 2019/5/5 17:01
 */
@Component
public class HttpFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest, servletResponse);
    }

}
