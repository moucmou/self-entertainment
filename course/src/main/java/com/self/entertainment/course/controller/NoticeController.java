package com.self.entertainment.course.controller;

import com.self.entertainment.course.common.ResponseData;
import com.self.entertainment.course.dao.entity.Notice;
import com.self.entertainment.course.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NoticeController {

    @Autowired
    NoticeService noticeService;

    @RequestMapping(value = "/admin/addNoticce", method = RequestMethod.POST)
    public ResponseData<String> add(String notice) {
        return noticeService.addNotice(notice);
    }

    @RequestMapping(value = "/anon/getNotice", method = RequestMethod.POST)
    public ResponseData<List<String>> get() {
        return noticeService.getAll();
    }
}
