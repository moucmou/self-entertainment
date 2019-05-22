package cn.example.amazingt.service;

import cn.example.amazingt.dto.LoginDto;
import cn.example.amazingt.entity.User;
import cn.example.amazingt.util.ResponseData;

import javax.servlet.http.HttpSession;

/**
 * @author AmazingZ
 * @date 2018/9/15 15:01
 */
public interface IUserService {
    /**
     * 登录校验
     * @param loginDto
     * @param httpSession
     * @return
     */
    ResponseData getByLogin(LoginDto loginDto, HttpSession httpSession);
    /**
     * 登出
     * @param user
     * @param httpSession
     * @return
     */
    ResponseData logout(HttpSession httpSession);

    /**
     * 添加用户
     * @param loginDto
     * @return
     */
    ResponseData addByLogin(LoginDto loginDto);
}
