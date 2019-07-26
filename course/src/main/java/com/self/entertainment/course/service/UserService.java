package com.self.entertainment.course.service;

import com.self.entertainment.course.common.ResponseData;
import com.self.entertainment.course.dao.entity.User;

/**
 * @author AmazingZ
 * @date 2019/6/1 16:16
 */
public interface UserService {

    ResponseData<String> addUser(User User);

    ResponseData<String> updateUser(User User);

    ResponseData<User> findByUserId();

    User findByUserNameAndPassWd(String userName, String passWd);


}
