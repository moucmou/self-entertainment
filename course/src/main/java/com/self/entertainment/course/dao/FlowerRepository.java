package com.self.entertainment.course.dao;

import com.self.entertainment.course.dao.entity.Flower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author AmazingZ
 * @date 2019/6/1 16:53
 */
public interface FlowerRepository extends JpaRepository<Flower, Integer>, JpaSpecificationExecutor<Flower> {

    void deleteByFlowerId(Long flowerId);

    boolean existsByFlowerName(String name);
}
