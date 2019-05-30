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
    GoodsMapper goodsMapper;
    @Autowired
    LfTbSendingFaceResultHistoryMapper lfTbSendingFaceResultHistoryMapper;
    @Autowired
    TbChannelMapper tbChannelMapper;
    @RequestMapping("/hello")
    public IPage<LfTbSendingFaceResultHistory> sayHell(){
        List<LfTbSendingFaceResultHistory> list= lfTbSendingFaceResultHistoryMapper.selectAll();
        QueryWrapper<LfTbSendingFaceResultHistory> queryWrapper= new QueryWrapper<>();
        queryWrapper.isNull(false,"recogName").ge("id","8a94d4f86ad2f76d016ad46a7b400003");

        tbChannelMapper.selectByPrimaryKey("72d8d907954440a48a7ac735cb04198b");
        tbChannelMapper.selectById("72d8d907954440a48a7ac735cb04198b");
        return  lfTbSendingFaceResultHistoryMapper.selectPage(new Page<>(),queryWrapper);
    }
}
