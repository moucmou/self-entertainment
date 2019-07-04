package com.self.entertainment.common;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.container.ContainerRequestFilter;
import java.io.IOException;

/**
 * @author AmazingZ
 * @date 2019/7/4 17:52
 */

/**
 * @see ContainerRequestFilter 的区别
 */
public class TokenInterceptor implements ClientRequestFilter {
    /**
     * ContainerRequestFilter
     *
     * @param requestContext
     * @throws IOException
     */
    @Override
    public void filter(ClientRequestContext requestContext) throws IOException {
        System.out.println("");
    }
}
