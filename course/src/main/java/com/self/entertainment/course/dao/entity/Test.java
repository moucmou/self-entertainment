package com.self.entertainment.course.dao.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author AmazingZ
 * @date 2019/7/3 9:57
 */
@Entity
@Data
@Table(name = "t_test")
public class Test implements Serializable {

    private static final long serialVersionUID = -5872568165613608162L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String test;
}
