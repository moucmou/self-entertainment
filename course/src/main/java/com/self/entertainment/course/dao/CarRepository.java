package com.self.entertainment.course.dao;

import com.self.entertainment.course.dao.entity.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;

import javax.transaction.Transactional;

public interface CarRepository  extends JpaRepository<Car, Long>, JpaSpecificationExecutor<Car> {
    @Transactional
    @Modifying
    void deleteByUserIdAndFlowerId(Long userId,Long flowerId );

    Car findByUserIdAndFlowerId(Long userId,Long flowerId);

    Page<Car> findByUserId(Long userId, Pageable pageable);


}
