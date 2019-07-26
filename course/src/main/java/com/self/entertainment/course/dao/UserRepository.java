package com.self.entertainment.course.dao;

import com.self.entertainment.course.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author AmazingZ
 * @date 2019/6/1 16:17
 */
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    boolean existsByUserName(String userName);

    User findByUserName(String userName);

    User findByUserNameAndPassword(String userName, String passWd);
}
