package com.self.entertainment.mybatis.repository;

import com.self.entertainment.mybatis.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

/**
 * @author AmazingZ
 * @date 2019/7/25 16:52
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TbUserMapperTest {

    @Autowired
    TbUserMapper tbUserMapper;


    @Test
    public void contextLoads() {
        /**
         * 查询 in
         */
//        List<User> list = tbUserMapper.findIn(Collections.singletonList(361216304260055041L));
//        User user = new User(4, 11);
//        user.setStartTime(LocalDateTime.now());

        /**
         * batchInsert
         */
//        List<User> list1 = new ArrayList<>();
//        User user2 = new User(5, 12);
//        user2.setStartTime(LocalDateTime.now().plusMonths(1));
//        user2.setSite("luofu");
//        list1.add(user2);
//        User user3 = new User(6, 13);
//        user3.setStartTime(LocalDateTime.now());
//        user3.setSite("guiyang");
//        list1.add(user3);
//        tbUserMapper.insertBatch(list1);

        /**
         * insertSingle
         */
//        user.setSite("luofu");
//        tbUserMapper.insert(user);

        /**
         * between and
         */
        LocalDateTime startTime = LocalDateTime.now().minusDays(1).plusMonths(1);
        LocalDateTime endTime = LocalDateTime.now().plusDays(1).plusMonths(1);
        List<User> users = tbUserMapper.findByTimeAndSite1(Date.from(startTime.atZone(ZoneId.of("+8")).toInstant()) , Date.from(endTime.atZone(ZoneId.of("+8")).toInstant()),"luofu");
        System.out.println();

//        LocalDateTime startTime = LocalDateTime.now().plusMonths(1);
//        tbUserMapper.findByTimeAndSite(Date.from(startTime.atZone(ZoneId.of("+8")).toInstant()),"luofu");
//        System.out.println();
    }
}