package com.self.entertainment.course.utils;

public enum Role {

    ADMIN(-1), USER(0);
    private Integer role;

    Role(Integer role) {
        this.role = role;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}
