package com.self.entertainment.mybatis.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.self.entertainment.mybatis.pojo.TbChannel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TbChannelMapper extends BaseMapper<TbChannel> {
    int deleteByPrimaryKey(String cIndexCode);

    int insert(TbChannel record);

    TbChannel selectByPrimaryKey(String cIndexCode);

    List<TbChannel> selectAll();

    int updateByPrimaryKey(TbChannel record);

}