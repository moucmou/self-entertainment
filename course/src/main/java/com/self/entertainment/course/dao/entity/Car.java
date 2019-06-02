package com.self.entertainment.course.dao.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author AmazingZ
 * @date 2019/6/1 15:28
 */
@Entity
@Data
@Table(name="t_car")
public class Car implements Serializable {

    private static final long serialVersionUID = -4823977237082446746L;
    /**
     *   userid int NOT NULL,
     *      flower_name char(10) NOT NULL,
     *      flower_outprice int NOT NULL,
     *      flower_number int NOT NULL,
     *        PRIMARY KEY(userid,flower_name),
     *      FOREIGN KEY (userid) REFERENCES users(userid),
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long userId;
    private String flowerName;
    private Long flowerId;
    private Integer flowerOutprice;
    private Integer flowerNumber;


}
