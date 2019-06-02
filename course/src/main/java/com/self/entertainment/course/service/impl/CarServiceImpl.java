package com.self.entertainment.course.service.impl;

import com.self.entertainment.course.common.ResponseData;
import com.self.entertainment.course.dao.CarRepository;
import com.self.entertainment.course.dao.entity.Car;
import com.self.entertainment.course.dao.entity.User;
import com.self.entertainment.course.service.CarService;
import com.self.entertainment.course.service.OrderService;
import com.self.entertainment.course.utils.CurrentUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepository carRepository;
    @Autowired
    OrderService orderService;

    @Override
    public ResponseData<Car> addItem(Long flowerId, Integer number) {

        Car car= carRepository.findByUserIdAndFlowerId(CurrentUtils.getCurrent().getUserId(),flowerId);
        if(Objects.isNull(car))  car = new Car();
        car.setUserId(CurrentUtils.getCurrent().getUserId());
        car.setFlowerId(flowerId);
        car.setFlowerNumber(Objects.isNull(car.getFlowerNumber())?  number:car.getFlowerNumber()+number);
        return ResponseData.success(carRepository.save(car));
    }

    @Override
    public ResponseData<String> delItem(Long flowerId ) {
        carRepository.deleteByUserIdAndFlowerId(CurrentUtils.getCurrent().getUserId(),flowerId);
        return ResponseData.success("");
    }

    @Override
    public ResponseData<String> account(Long[] flowerIds) {
        return null;
    }

}
