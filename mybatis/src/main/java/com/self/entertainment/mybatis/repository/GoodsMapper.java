package com.self.entertainment.mybatis.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.self.entertainment.mybatis.pojo.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsMapper  extends BaseMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Goods record);

    Goods selectByPrimaryKey(Integer id);

    List<Goods> selectAll();

    int updateByPrimaryKey(Goods record);
}