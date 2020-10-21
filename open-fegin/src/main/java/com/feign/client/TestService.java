package com.feign.client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface TestService {

    @GetMapping(value = {"/test/hello"})
    Object queryByDictValCode(@RequestParam("code") String code);

}
