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
@Data
@Entity
public class Flower implements Serializable {

    private static final long serialVersionUID = 2604396364055746843L;
    /**
     *    flower_id int NOT NULL,
     *    flower_name char(10) NOT NULL,
     *    flower_language char(50),
     *    flower_inprice int NOT NULL,
     *    flower_outprice int NOT NULL,
     *    flower_state char(50) NOT NULL,
     *    PRIMARY KEY(flower_id),
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long flowerId;
    private String flowerName;
    private String flowerLanguage;
    private Integer flowerInprice;
    private Integer flowerOutprice;
    private Integer flowerState;
    private String picUrl;





}
