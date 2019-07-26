package com.self.entertainment.mybatis.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.self.entertainment.mybatis.pojo.LfTbSendingFaceResultHistory;
import com.self.entertainment.mybatis.repository.GoodsMapper;
import com.self.entertainment.mybatis.repository.LfTbSendingFaceResultHistoryMapper;
import com.self.entertainment.mybatis.repository.TbChannelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.self.entertainment.mybatis.service.TestService;

import java.util.List;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * @author AmazingZ
 * @date 2019/5/30 14:05
 */
@RestController
@RequestMapping("/")
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping("/hello")
    public IPage<LfTbSendingFaceResultHistory> sayHell() {
        return testService.getCache(null);
    }
}
