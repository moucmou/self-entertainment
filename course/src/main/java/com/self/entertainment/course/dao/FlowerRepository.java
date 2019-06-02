package com.self.entertainment.course.dao;

import com.self.entertainment.course.dao.entity.Flower;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author AmazingZ
 * @date 2019/6/1 16:53
 */
public interface FlowerRepository extends JpaRepository<Flower, Long>, JpaSpecificationExecutor<Flower> {
    @Transactional
    @Modifying
    void deleteByFlowerId(Long flowerId);

    boolean existsByFlowerName(String name);

    Page<Flower> findByFlowerNameLike(String flowerName, Pageable page );

    List<Flower> findByFlowerIdIn(Long[] ids);
}
