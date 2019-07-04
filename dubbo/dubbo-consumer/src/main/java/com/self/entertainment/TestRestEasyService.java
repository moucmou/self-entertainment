package com.self.entertainment;

import com.self.entertainment.common.Interceptor;
import com.self.entertainment.common.ServerType;
import com.self.entertainment.common.TokenInterceptor;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 * @author AmazingZ
 * @date 2019/7/4 17:23
 */
@ServerType("justTest")
@Interceptor(interceptorClass= TokenInterceptor.class)
@Path("resteasy")
public interface TestRestEasyService {

    @POST
    @Path("echo")
    @Consumes({MediaType.APPLICATION_JSON})
    String echo(String repeat);
}
