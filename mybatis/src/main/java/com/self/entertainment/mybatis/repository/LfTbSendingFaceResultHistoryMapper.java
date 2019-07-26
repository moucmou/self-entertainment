package com.self.entertainment.mybatis.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.self.entertainment.mybatis.pojo.LfTbSendingFaceResultHistory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//@Mapper
public interface LfTbSendingFaceResultHistoryMapper extends BaseMapper<LfTbSendingFaceResultHistory> {
    int deleteByPrimaryKey(String id);

    int insert(LfTbSendingFaceResultHistory record);

    LfTbSendingFaceResultHistory selectByPrimaryKey(String id);

    List<LfTbSendingFaceResultHistory> selectAll();

    int updateByPrimaryKey(LfTbSendingFaceResultHistory record);
}