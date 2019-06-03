package com.self.entertainment.course.service.impl;

import com.self.entertainment.course.common.ResponseData;
import com.self.entertainment.course.dao.NoticeRepository;
import com.self.entertainment.course.dao.entity.Notice;
import com.self.entertainment.course.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author AmazingZ
 * @date 2019/6/3 22:01
 */
@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    NoticeRepository noticeRepository;

    @Override
    public ResponseData<String> addNotice(String notice) {
        Notice temp = new Notice();
        temp.setNotice(notice);
        noticeRepository.save(temp);
        return ResponseData.success("");
    }

    @Override
    public ResponseData<List<String>> getAll() {
        List<String> list=new ArrayList<>();
        for(Notice notice:noticeRepository.findAll()) {
            list.add(notice.getNotice());
        }
        return ResponseData.success(list);
    }
}
