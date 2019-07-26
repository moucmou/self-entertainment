package cn.example.amazingt.dao;

import cn.example.amazingt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author AmazingZ
 * @date 2018/9/15 15:21
 */

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    /**
     * 根据用户名获取用户信息（包括密码））
     *
     * @param userName 用户名
     * @return
     */
    @Query("select bu from User bu where bu.userName = :userName ")
    User getByUserNameIncPassword(@Param("userName") String userName);

}
