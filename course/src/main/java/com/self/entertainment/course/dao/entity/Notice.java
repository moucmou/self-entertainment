package com.self.entertainment.course.dao.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author AmazingZ
 * @date 2019/6/3 21:58
 */

@Entity
@Data
@Table(name = "notice")
public class Notice implements Serializable {
    private static final long serialVersionUID = 1674004940036883846L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String notice;
}
