package com.self.entertainment.course.controller;

import com.self.entertainment.course.common.ResponseData;
import com.self.entertainment.course.dao.entity.Order;
import com.self.entertainment.course.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/user/createOrder", method = RequestMethod.POST)
    public ResponseData<Order> createOrder(Long[] ids, String comment) {
        return orderService.createOrder(ids, comment);
    }

    @RequestMapping(value = "/user/getOrder", method = RequestMethod.POST)
    public ResponseData<Page<Order>> getOrder(Integer pageNo, Integer pageSize) {
        return orderService.getOrder(pageNo, pageSize);
    }

    @RequestMapping(value = "/admin/getAllOrder", method = RequestMethod.POST)
    public ResponseData<Page<Order>> getAllOrder(Integer pageNo, Integer pageSize) {
        return orderService.getOrder(pageNo, pageSize);
    }
}
