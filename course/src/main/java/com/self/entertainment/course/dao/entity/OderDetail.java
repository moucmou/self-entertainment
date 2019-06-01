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
public class OderDetail implements Serializable {
    private static final long serialVersionUID = -8704874738293655474L;
    /**
     *     order_id int NOT NULL,
     *      flower_name char(10) NOT NULL,
     *      flower_outprice int NOT NULL,
     *      flower_number int NOT NULL,
     *      FOREIGN KEY (order_id) REFERENCES orders(order_id),
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;
    private String flowerName;
    private Integer flowerOutprice;
    private Integer flowerNumber;

}
