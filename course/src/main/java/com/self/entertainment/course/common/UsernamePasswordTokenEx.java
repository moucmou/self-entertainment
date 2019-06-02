package com.self.entertainment.course.common;

import org.apache.shiro.authc.UsernamePasswordToken;

public class UsernamePasswordTokenEx extends UsernamePasswordToken {

    private Integer role;

    public UsernamePasswordTokenEx(final String username, final String password, Integer role) {
        super(username, password);
        this.role = role;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}
