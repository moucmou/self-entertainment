package com.self.entertainment.mybatis.repository;

import com.self.entertainment.mybatis.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Mapper
public interface TbUserMapper {

    int insert(User user);

    List<User> findAll();

    List<User> findIn(List<Long> ids);

    User findById(Long id);

    void insertBatch(List<User> user);

    List<User> findByTimeAndSite1(@Param("startTime") Date startTime, @Param("endTime") Date endTime,@Param("site")String site);

    List<User> findByTimeAndSite(@Param("startTime") Date startTime,@Param("site") String site);

    List<User> findByTime(@Param("startTime") Date startTime);

    List<User> findByIdzz(@Param("id")Long id);
}