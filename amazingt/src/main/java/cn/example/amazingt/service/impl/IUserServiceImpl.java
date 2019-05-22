package cn.example.amazingt.service.impl;

import cn.example.amazingt.constant.CodeConfig;
import cn.example.amazingt.constant.UserErrorEnum;
import cn.example.amazingt.dao.IUserRepository;
import cn.example.amazingt.dto.LoginDto;
import cn.example.amazingt.entity.User;
import cn.example.amazingt.listener.SessionListener;
import cn.example.amazingt.service.IUserService;
import cn.example.amazingt.util.MessageDigestUtil;
import cn.example.amazingt.util.ResponseData;
import cn.example.amazingt.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @author AmazingZ
 * @date 2018/9/15 15:08
 */
@Service
public class IUserServiceImpl implements IUserService {
    private final static Logger logger = LoggerFactory.getLogger(IUserServiceImpl.class);


    @Autowired
    private IUserRepository userRepository;

    @Override
    public ResponseData getByLogin(LoginDto loginDto, HttpSession httpSession) {
        long start = System.currentTimeMillis();
        if(null != this.validate(loginDto)){
            return  this.validate(loginDto);
        }
        User bu = userRepository.getByUserNameIncPassword(loginDto.getLoginName());
        if (!bu.getPassword().equals(MessageDigestUtil.sha256Hex(loginDto.getPassword() + loginDto.getSalt()))) {
            return new ResponseData(UserErrorEnum.PASSWORD_ERROR.getCode(), StringUtils.splice(
                    UserErrorEnum.PASSWORD_ERROR.getMessage(), ",用户名=", loginDto.getLoginName()), null);
        }
        long end = System.currentTimeMillis();
        logger.info("登录认证时间，时长={}", end - start);
        httpSession.setAttribute("user",bu);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("indexCode", bu.getIndexCode());
        SessionListener.getNameSet().add(bu.getUserName());
        return new ResponseData(UserErrorEnum.SUCCESS.getCode(),StringUtils.splice("登录成功,用户名=", loginDto.getLoginName()), map);
    }

    @Override
    public ResponseData logout(HttpSession httpSession) {
        User user=(User)httpSession.getAttribute("user");
        httpSession.removeAttribute("user");
        httpSession.invalidate();
        SessionListener.getNameSet().remove(user.getUserName());
        return new ResponseData(UserErrorEnum.SUCCESS.getCode(),StringUtils.splice("注销成功,用户名=", user.getUserName()), null);
    }

    @Override
    public ResponseData addByLogin(LoginDto loginDto) {
        User bu = userRepository.getByUserNameIncPassword(loginDto.getLoginName());
        if (bu != null) {
            return  new ResponseData(UserErrorEnum.USERNAME_NOT_EXSIT.getCode(),
                    StringUtils.splice(UserErrorEnum.USERNAME_EXSIT.getMessage(), ",用户名=", loginDto.getLoginName()),null);
        }
        User user =new User();
        loginDto.setSalt(CodeConfig.SALT);
        user.setIndexCode(UUID.randomUUID().toString().replace("-",""));
        user.setUserName(loginDto.getLoginName());
        user.setPassword(MessageDigestUtil.sha256Hex(loginDto.getPassword() + loginDto.getSalt()));
        userRepository.save(user);
        return new ResponseData(UserErrorEnum.SUCCESS.getCode(),StringUtils.splice("注册成功,用户名=", loginDto.getLoginName()), null);
    }

    private ResponseData validate(LoginDto loginDto){
        if (loginDto == null) {
            return new ResponseData(UserErrorEnum.PARAM_EMPTY.getCode(),UserErrorEnum.PARAM_EMPTY.getMessage(),null);
        }
        loginDto.setSalt(CodeConfig.SALT);
        if (StringUtils.isEmpty(loginDto.getLoginName())) {
            return new ResponseData(UserErrorEnum.USERNAME_EMPTY.getCode(),StringUtils.splice(
                    UserErrorEnum.USERNAME_EMPTY.getMessage(), ",用户名=", loginDto.getLoginName(),  null));
        }
        if (StringUtils.isEmpty(loginDto.getPassword())) {
            return new ResponseData(UserErrorEnum.PASSWORD_EMPTY.getCode(), StringUtils.splice(
                    UserErrorEnum.PASSWORD_EMPTY.getMessage(), ",用户名=", loginDto.getLoginName()), null);
        }
        User bu = userRepository.getByUserNameIncPassword(loginDto.getLoginName());
        if (bu == null) {
            return  new ResponseData(UserErrorEnum.USERNAME_NOT_EXSIT.getCode(),
                    StringUtils.splice(UserErrorEnum.USERNAME_NOT_EXSIT.getMessage(), ",用户名=", loginDto.getLoginName()),null);
        }
        return null;
    }
}
