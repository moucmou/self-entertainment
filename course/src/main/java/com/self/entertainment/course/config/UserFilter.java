package com.self.entertainment.course.config;

import com.self.entertainment.course.dao.entity.User;
import com.self.entertainment.course.utils.Role;
import org.springframework.stereotype.Component;

@Component
public class UserFilter extends CustomFilter {
    @Override
    public boolean hasPermitted(Integer role) {

        return Role.USER.getRole().equals(role);
    }
}
