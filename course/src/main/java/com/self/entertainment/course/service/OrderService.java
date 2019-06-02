package com.self.entertainment.course.service;

import com.self.entertainment.course.common.ResponseData;
import com.self.entertainment.course.dao.entity.Order;
import org.springframework.data.domain.Page;

public interface OrderService {

    ResponseData<Order> createOrder(Long[] ids, String ops);

    Order payOrder(Order Order);

    ResponseData<Page<Order>> getOrder( Integer pageNo,Integer pageSize) ;

    ResponseData<Page<Order>> getAllOrder( Integer pageNo,Integer pageSize) ;

}
