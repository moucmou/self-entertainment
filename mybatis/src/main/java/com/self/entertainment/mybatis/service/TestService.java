package com.self.entertainment.mybatis.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.self.entertainment.mybatis.pojo.LfTbSendingFaceResultHistory;
import org.springframework.stereotype.Service;

/**
 * @author AmazingZ
 * @date 2019/5/31 17:14
 */
public interface TestService {

    IPage<LfTbSendingFaceResultHistory> getCache(String x);
}
