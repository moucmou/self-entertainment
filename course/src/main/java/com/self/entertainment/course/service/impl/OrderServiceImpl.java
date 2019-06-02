package com.self.entertainment.course.service.impl;

import com.self.entertainment.course.common.ResponseData;
import com.self.entertainment.course.dao.CarRepository;
import com.self.entertainment.course.dao.FlowerRepository;
import com.self.entertainment.course.dao.OrderDetailReposity;
import com.self.entertainment.course.dao.OrderRepository;
import com.self.entertainment.course.dao.entity.*;
import com.self.entertainment.course.service.FlowerService;
import com.self.entertainment.course.service.OrderService;
import com.self.entertainment.course.utils.CurrentUtils;
import com.self.entertainment.course.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    FlowerRepository flowerRepository;
    @Autowired
    CarRepository carRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderDetailReposity orderDetailReposity;

    @Transactional
    @Override
    public ResponseData<Order> createOrder(Long[] ids, String ops) {
        List<Flower> list = flowerRepository.findByFlowerIdIn(ids);
        User user = CurrentUtils.getCurrent();
        List<OderDetail> orderDetailList = new ArrayList<>();
        Order order = new Order();
        order.setOrderAddress(user.getUserAddress());
        order.setOrderTime(System.currentTimeMillis());
        order.setOrderPs(ops);
        order.setUserId(user.getUserId());
        orderRepository.save(order);
        for (Flower flower : list) {
            OderDetail orderDetail = new OderDetail();
            orderDetail.setFlowerName(flower.getFlowerName());
            Car car = carRepository.findByUserIdAndFlowerId(user.getUserId(), flower.getFlowerId());
            carRepository.deleteByUserIdAndFlowerId(user.getUserId(), flower.getFlowerId());
            orderDetail.setFlowerNumber(car.getFlowerNumber());
            if (flower.getFlowerNumber() - car.getFlowerNumber() < 0)
                throw new RuntimeException("库存不够");
            flower.setFlowerNumber(flower.getFlowerNumber() - car.getFlowerNumber());
            orderDetail.setFlowerOutprice(flower.getFlowerOutprice());
            orderDetail.setOrderId(order.getOrderId());
            orderDetailList.add(orderDetail);
        }
        orderDetailReposity.saveAll(orderDetailList);
        return ResponseData.success(order);
    }

    @Override
    public Order payOrder(Order Order) {
        return null;
    }

    @Override
    public ResponseData<Page<Order>> getOrder(Integer pageNo, Integer pageSize) {
        ;
        Page<Order> orders = orderRepository.findByUserId(CurrentUtils.getCurrent().getUserId(), PageUtils.of(pageNo, pageSize));
        for (Order order : orders.getContent()) {
            order.setList(orderDetailReposity.findByOrderId(order.getOrderId()));
        }
        return ResponseData.success(orders);
    }

    @Override
    public ResponseData<Page<Order>> getAllOrder(Integer pageNo, Integer pageSize) {
        ;
        Page<Order> orders = orderRepository.findAll(PageUtils.of(pageNo, pageSize));
        for (Order order : orders.getContent()) {
            order.setList(orderDetailReposity.findByOrderId(order.getOrderId()));
        }
        return ResponseData.success(orders);
    }
}
