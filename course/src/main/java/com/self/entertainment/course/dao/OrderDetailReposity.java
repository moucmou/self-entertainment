package com.self.entertainment.course.dao;

import com.self.entertainment.course.dao.entity.OderDetail;
import com.self.entertainment.course.dao.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface OrderDetailReposity extends JpaRepository<OderDetail, Long>, JpaSpecificationExecutor<OderDetail> {

     List<OderDetail> findByOrderId(Long orderId);
}
