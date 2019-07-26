package com.self.entertainment.course.service.impl;

import com.self.entertainment.course.common.ResponseData;
import com.self.entertainment.course.dao.UserRepository;
import com.self.entertainment.course.dao.entity.User;
import com.self.entertainment.course.service.UserService;
import com.self.entertainment.course.utils.CurrentUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author AmazingZ
 * @date 2019/6/1 16:16
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseData<String> addUser(User User) {
        if (userRepository.existsByUserName(User.getUserName())) {
            return ResponseData.error("用户名重复");
        }
        userRepository.save(User);
        return ResponseData.success("");
    }

    @Override
    public ResponseData<String> updateUser(User User) {
        userRepository.save(User);
        return ResponseData.success("");
    }

    @Override
    public ResponseData<User> findByUserId() {
        return ResponseData.success(userRepository.findByUserName(CurrentUtils.getCurrent().getUserName()));
    }

    @Override
    public User findByUserNameAndPassWd(String userName, String passWd) {
        return userRepository.findByUserNameAndPassword(userName, passWd);
    }
}
