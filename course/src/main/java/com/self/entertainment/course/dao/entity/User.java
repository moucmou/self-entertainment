package com.self.entertainment.course.dao.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author AmazingZ
 * @date 2019/6/1 15:29
 */
@Entity
@Table(name = "t_user")
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -9199589208218587959L;
    /**
     * username char(50) NOT NULL,
     * userId int NOT NULL,
     * userpassword int NOT NULL,
     * usertruename char(10) NOT NULL,
     * userphone char(50) NOT NULL,
     * useraddress char(50),
     * PRIMARY KEY (userid),
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String name;
    private String password;
    private String userName;
    private Long userPhone;
    private String userAddress;
    private Integer role = 0;
}
