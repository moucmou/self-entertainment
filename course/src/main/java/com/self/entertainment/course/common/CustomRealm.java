package com.self.entertainment.course.common;

import com.self.entertainment.course.dao.entity.User;
import com.self.entertainment.course.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component("authorizer")
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordTokenEx upToken = (UsernamePasswordTokenEx) token;
        String username = upToken.getUsername();
        User user = userService.findByUserNameAndPassWd(username, String.valueOf(upToken.getPassword()));
        if (Objects.isNull(user) || !user.getRole().equals(upToken.getRole())) throw new AccountException("用户名或密码不正确");

        return new SimpleAuthenticationInfo(user, String.valueOf(upToken.getPassword()), getName());
    }
}
