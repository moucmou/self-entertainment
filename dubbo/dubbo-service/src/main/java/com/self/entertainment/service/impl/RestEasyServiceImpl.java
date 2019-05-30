package com.self.entertainment.service.impl;

import entertainment.service.RestEasyService;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 * @author AmazingZ
 * @date 2019/5/24 17:12
 */


public class RestEasyServiceImpl implements RestEasyService {


    @Override
    public String echo(String repeat) {
        return repeat;
    }
}
