package com.self.entertainment.course.controller;

import com.self.entertainment.course.common.ResponseData;
import com.self.entertainment.course.dao.entity.Flower;
import com.self.entertainment.course.service.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author AmazingZ
 * @date 2019/6/1 17:00
 */
@RestController
@RequestMapping("/")
public class FlowerController {

    @Autowired
    FlowerService flowerService;

    @RequestMapping(value = "/anon/getAllFlowers", method = RequestMethod.POST)
    public ResponseData<Page<Flower>> getAll(Integer pageNo, Integer pageSize) {
        return flowerService.getAllFlowers(pageNo, pageSize);
    }

    @RequestMapping(value = "/anon/getByName", method = RequestMethod.POST)
    public ResponseData<Page<Flower>> getOneFlower(String flowerName, Integer pageNo, Integer pageSize) {
        return flowerService.findByFlowerName(flowerName, pageNo, pageSize);
    }

    //
    public ResponseData<String> uploadPic(MultipartFile file) {
        return ResponseData.success("");
    }

    @RequestMapping(value = "/admin/updateFlower", method = RequestMethod.POST)
    public ResponseData<Flower> updateFlower(Flower flower, String file) {
        return flowerService.addFlower(flower, file);
    }

    @RequestMapping(value = "/admin/addFlower", method = RequestMethod.POST)
    public ResponseData<Flower> addFlower(Flower flower, String file) {
        return flowerService.addFlower(flower, file);
    }

    @RequestMapping(value = "/admin/delFlower", method = RequestMethod.POST)
    public ResponseData<String> delFlower(Long flowerId) {
        flowerService.deleteFlower(flowerId);
        return ResponseData.success("");
    }

    @RequestMapping(value = "/anon/findByFlowerIds", method = RequestMethod.POST)
    public ResponseData<List<Flower>> findByFlowerIds(Long[] ids) {
        return flowerService.findByFlowerIds(ids);
    }
}
