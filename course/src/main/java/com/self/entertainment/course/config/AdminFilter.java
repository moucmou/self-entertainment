package com.self.entertainment.course.config;

import com.self.entertainment.course.dao.entity.User;
import com.self.entertainment.course.utils.Role;
import org.springframework.stereotype.Component;

@Component
public class AdminFilter extends CustomFilter {
    @Override
    public boolean hasPermitted(Integer role) {

        return Role.ADMIN.getRole().equals(role);
    }
}
