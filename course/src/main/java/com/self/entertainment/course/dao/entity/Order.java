package com.self.entertainment.course.dao.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author AmazingZ
 * @date 2019/6/1 15:29
 */
@Entity
@Data
@Table(name = "t_order")
public class Order implements Serializable {


    private static final long serialVersionUID = -2640199615072326164L;
    /**
     * order_id int NOT NULL,
     * username char(50) NOT NULL,
     * order_time varchar(50) NOT NULL,
     * order_address char(50) NOT NULL,
     * order_ps char(100),
     * PRIMARY KEY (order_id),
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;
    private Long userId;

    private Long orderTime;
    private String orderAddress;
    private String orderPs;
    @Transient
    private List<OderDetail> list;


}
