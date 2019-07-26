package com.self.entertainment.mybatis.pojo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author AmazingZ
 * @date 2019/7/18 15:39
 */
public class User implements Serializable {
    private static final long serialVersionUID = -3515529656344272645L;
    private Long id;
    private int cityId;
    private Integer test;
    private Date startTime;
    private String site;

    public void setTest(Integer test) {
        this.test = test;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }




    public int getTest() {
        return test;
    }

    public User(Long id, int cityId, Integer test) {
        this.id = id;
        this.cityId = cityId;
        this.test = test;
    }

    public void setTest(int test) {
        this.test = test;
    }

    public User(int cityId) {
        this.cityId = cityId;
    }

    public User(int cityId, int test) {
        this.cityId = cityId;
        this.test = test;
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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public User(Long id, int cityId, Integer test, Date startTime, String site) {
        this.id = id;
        this.cityId = cityId;
        this.test = test;
        this.startTime = startTime;
        this.site = site;
    }
}
