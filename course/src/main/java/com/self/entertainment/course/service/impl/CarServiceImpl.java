package com.self.entertainment.course.service.impl;

import com.self.entertainment.course.common.ResponseData;
import com.self.entertainment.course.dao.CarRepository;
import com.self.entertainment.course.dao.FlowerRepository;
import com.self.entertainment.course.dao.entity.Car;
import com.self.entertainment.course.dao.entity.Flower;
import com.self.entertainment.course.service.CarService;
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
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepository carRepository;
    @Autowired
    OrderService orderService;
    @Autowired
    FlowerRepository flowerRepository;

    @Override
    @Transactional
    public ResponseData<Car> addItem(Long flowerId, Integer number) {

        Car car = carRepository.findByUserIdAndFlowerId(CurrentUtils.getCurrent().getUserId(), flowerId);
        List<Flower> flower = flowerRepository.findByFlowerIdIn(new Long[]{flowerId});
        if (Objects.isNull(car)) car = new Car();
        car.setUserId(CurrentUtils.getCurrent().getUserId());
        car.setFlowerId(flowerId);
        car.setFlowerNumber(number);
        car.setFlowerName(flower.get(0).getFlowerName());
        car.setFlowerOutprice(flower.get(0).getFlowerOutprice());
        car.setPicUrl(flower.get(0).getPicUrl());
        return ResponseData.success(carRepository.save(car));
    }

    @Override
    public ResponseData<String> delItem(Long flowerId) {
        carRepository.deleteByUserIdAndFlowerId(CurrentUtils.getCurrent().getUserId(), flowerId);
        return ResponseData.success("");
    }

    @Override
    public ResponseData<String> account(Long[] flowerIds) {
        return null;
    }

    @Override
    public ResponseData<Page<Car>> getItem(Integer pageNo, Integer pageSize) {
        Page<Car> page = carRepository.findByUserId(CurrentUtils.getCurrent().getUserId(), PageUtils.buildPageRequest(pageNo, pageSize, null));
        for (Car car : page.getContent()) {
            File picFile = new File(TempFile.getInstance().getFile(), String.valueOf(car.getFlowerId()));
            try {
                car.setPicUrl(FileUtils.readFileToString(picFile, "UTF-8"));
                ;
            } catch (IOException e) {
                log.error("读数据失败", e);
            }
        }
        return ResponseData.success(page);
    }

}
