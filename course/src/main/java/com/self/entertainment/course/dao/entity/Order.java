package com.self.entertainment.course.dao.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author AmazingZ
 * @date 2019/6/1 15:29
 */
@Entity
@Data
public class Order implements Serializable {


    private static final long serialVersionUID = -2640199615072326164L;
    /**
     *    order_id int NOT NULL,
     *     username char(50) NOT NULL,
     *     order_time varchar(50) NOT NULL,
     *     order_address char(50) NOT NULL,
     *     order_ps char(100),
     *     PRIMARY KEY (order_id),
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;
    private String userId;

    private Long orderTime;
    private String orderAddress;
    private String orderPs;


}
