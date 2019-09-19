package com.self.entertainment.mybatis.pojo;

/**
 * @author AmazingZ
 * @date 2019/8/8 17:12
 */
public class Role {

    private Long id;
    private int cityId;
    private String name;

    public Role() {
    }

    public Role(Long id, int cityId, String name) {
        this.id = id;
        this.cityId = cityId;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
