package com.self.entertainment.course.controller;

import com.self.entertainment.course.utils.PicUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/anon")
public class StorageController {

    @RequestMapping(value = "/storage", method = RequestMethod.GET)
    public void getPic(HttpServletResponse response, String picId) {
        PicUtils.getPic(picId, response);
    }
}
