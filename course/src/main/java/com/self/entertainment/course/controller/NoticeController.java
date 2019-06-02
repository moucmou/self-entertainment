package com.self.entertainment.course.controller;

import com.self.entertainment.course.common.ResponseData;
import com.self.entertainment.course.utils.PicUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticeController {

    @RequestMapping(value = "/admin/addNoticce",method = RequestMethod.POST)
    public ResponseData<String> add(String notice){
        PicUtils.addNote(notice);
       return ResponseData.success("") ;
    }
    @RequestMapping(value = "/anon/getNotice",method = RequestMethod.POST)
    public ResponseData<String> get(){
        return ResponseData.success( PicUtils.readNote()) ;
    }
}
