package com.self.entertainment.jetty.server;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author AmazingZ
 * @date 2019/5/29 15:49
 */
@Controller
@Slf4j
public class TestController {

    @Autowired
    ObjectMapper objectMapper;

    @RequestMapping("/hello")
    @ResponseBody
    public String say(@RequestBody Object object){
        try {
           log.info(objectMapper.writeValueAsString(object));
        } catch (JsonProcessingException e) {
            log.error("",e);
        }
        return "";
    }
}
