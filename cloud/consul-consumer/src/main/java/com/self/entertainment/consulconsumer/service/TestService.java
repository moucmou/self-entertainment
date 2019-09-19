package com.self.entertainment.consulconsumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 * @author AmazingZ
 * @date 2019/9/17 20:33
 */
public interface TestService {

    @GET
    @Path(value="/test/echo")

    String echo( @QueryParam("x") String x);

}
