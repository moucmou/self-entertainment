package com.self.entertainment.course.service;

import com.self.entertainment.course.common.ResponseData;
import com.self.entertainment.course.dao.entity.Notice;

import java.util.List;

/**
 * @author AmazingZ
 * @date 2019/6/3 22:00
 */
public interface NoticeService {

    ResponseData<String> addNotice(String notice);

    ResponseData<List<String>> getAll();
}
