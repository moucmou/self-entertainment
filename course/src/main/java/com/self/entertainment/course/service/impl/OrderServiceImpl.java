package com.self.entertainment.course.service.impl;

import com.self.entertainment.course.common.ResponseData;
import com.self.entertainment.course.dao.CarRepository;
import com.self.entertainment.course.dao.FlowerRepository;
import com.self.entertainment.course.dao.OrderDetailReposity;
import com.self.entertainment.course.dao.OrderRepository;
import com.self.entertainment.course.dao.entity.*;
import com.self.entertainment.course.service.OrderService;
import com.self.entertainment.course.utils.CurrentUtils;
import com.self.entertainment.course.utils.PageUtils;
import com.self.entertainment.course.utils.TempFile;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
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
            orderDetail.setFlowerId(flower.getFlowerId());
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
        Page<Order> orders = orderRepository.findByUserId(CurrentUtils.getCurrent().getUserId(), PageUtils.buildPageRequest(pageNo, pageSize, null));
        for (Order order : orders.getContent()) {
            List<OderDetail> temp = orderDetailReposity.findByOrderId(order.getOrderId());
            for (OderDetail orderDetail : temp) {
                File picFile = new File(TempFile.getInstance().getFile(), String.valueOf(orderDetail.getFlowerId()));
                try {
                    orderDetail.setPicUrl(FileUtils.readFileToString(picFile, "UTF-8"));
                    ;
                } catch (IOException e) {
                    log.error("读数据失败", e);
                }
            }
            order.setList(temp);
        }
        return ResponseData.success(orders);
    }

    @Override
    public ResponseData<Page<Order>> getAllOrder(Integer pageNo, Integer pageSize) {
        ;
        Page<Order> orders = orderRepository.findAll(PageUtils.buildPageRequest(pageNo, pageSize, null));
        for (Order order : orders.getContent()) {
            List<OderDetail> temp = orderDetailReposity.findByOrderId(order.getOrderId());
            for (OderDetail orderDetail : temp) {
                File picFile = new File(TempFile.getInstance().getFile(), String.valueOf(orderDetail.getFlowerId()));
                try {
                    orderDetail.setPicUrl(FileUtils.readFileToString(picFile, "UTF-8"));
                    ;
                } catch (IOException e) {
                    log.error("读数据失败", e);
                }
            }
            order.setList(temp);
        }
        return ResponseData.success(orders);
    }
}
