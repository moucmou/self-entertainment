package com.self.entertainment.mybatis.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.self.entertainment.mybatis.pojo.LfTbSendingFaceResultHistory;
import com.self.entertainment.mybatis.repository.TbUserMapper;
import com.self.entertainment.mybatis.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author AmazingZ
 * @date 2019/5/31 17:15
 */
//@Slf4j
@Service
public class TestServiceImpl implements TestService {

    //    @Autowired
//    LfTbSendingFaceResultHistoryMapper lfTbSendingFaceResultHistoryMapper;
//    @Autowired
//    TbChannelMapper tbChannelMapper;
    @Autowired
    ObjectMapper objectMapper;

//    @Resource
//    RedisTemplate redisTempalte;
    @Autowired
    TbUserMapper tbUserMapper;
    @Override
//    @Cacheable("asdasd")
    public IPage<LfTbSendingFaceResultHistory> getCache(String x) {
//        redisTempalte.opsForHash().put("IpAndPort", "asw", new HashMap<String, Object>());
        return null;
//        return lfTbSendingFaceResultHistoryMapper.selectPage(new Page<>(), null);
    }
}
