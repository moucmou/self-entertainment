package com.self.entertainment.simple;

import lombok.extern.slf4j.Slf4j;

/**
 * @author AmazingZ
 * @date 2019/5/22 10:01
 */
@Slf4j
public class SimpleServlet extends AbstractServlet {

    @Override
    public void doGet(SimpleRequest simpleRequest, SimpleResponse simpleResponse) {
        simpleResponse.write("hello World  doGet");
    }

    @Override
    public void doPost(SimpleRequest myRequest, SimpleResponse simpleResponse) {
        simpleResponse.write("hello World  doPost");
    }

}
