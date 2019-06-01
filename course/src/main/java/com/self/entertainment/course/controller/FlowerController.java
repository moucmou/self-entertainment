package com.self.entertainment.course.controller;

import com.self.entertainment.course.common.ResponseData;
import com.self.entertainment.course.dao.entity.Flower;
import com.self.entertainment.course.service.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author AmazingZ
 * @date 2019/6/1 17:00
 */
@RestController
@RequestMapping("/flower")
public class FlowerController {

//    @Autowired
//    FlowerService flowerService;
//    @RequestMapping(value = "/getAllFlowers" ,method = RequestMethod.POST)
//    public ResponseData<Flower> getAll(){
//        flowerService
//    }
//
//    @RequestMapping(value = "/getOneFlower" ,method = RequestMethod.POST)
//    public ResponseData<Flower> getOneFlower(Integer id){
//
//    }
//    @RequestMapping(value = "/updateFlower" ,method = RequestMethod.POST)
//    public ResponseData<Flower> updateFlower(Flower flower){
//
//    }
//    @RequestMapping(value = "/addFlower" ,method = RequestMethod.POST)
//    public ResponseData<Flower> addFlower(Flower flower,String pic){
//
//    }
}
