package com.self.entertainment.course.controller;

import com.self.entertainment.course.common.ResponseData;
import com.self.entertainment.course.dao.entity.Car;
import com.self.entertainment.course.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class CarController {

    @Autowired
    CarService carService;

    @RequestMapping(value="/addToCar",method = RequestMethod.POST)
    public ResponseData<Car>  addItem(Long flowerId,Integer number){
      return  carService.addItem(flowerId,number) ;
    }
    @RequestMapping(value="/delFromCar",method = RequestMethod.POST)
    public ResponseData<String>  delItem(Long flowerId){
        return  carService.delItem(flowerId) ;
    }
    @RequestMapping(value="/getCar",method = RequestMethod.POST)
    public ResponseData<Page<Car>>  getCar(Integer pageNo, Integer pageSize){
        return  carService.getItem(pageNo,pageSize) ;
    }

}
