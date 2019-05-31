package com.self.entertainment.mybatis.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.self.entertainment.mybatis.pojo.LfTbSendingFaceResultHistory;
import com.self.entertainment.mybatis.repository.LfTbSendingFaceResultHistoryMapper;
import com.self.entertainment.mybatis.repository.TbChannelMapper;
import com.self.entertainment.mybatis.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.Duration;

/**
 * @author AmazingZ
 * @date 2019/5/31 17:15
 */
@Slf4j
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    LfTbSendingFaceResultHistoryMapper lfTbSendingFaceResultHistoryMapper;
    @Autowired
    TbChannelMapper tbChannelMapper;
    @Autowired
    ObjectMapper objectMapper;
    @Override
    @Cacheable("asdasd")
    public IPage<LfTbSendingFaceResultHistory> getCache(String x) {
        return lfTbSendingFaceResultHistoryMapper.selectPage(new Page<>(),null);
    }
}
