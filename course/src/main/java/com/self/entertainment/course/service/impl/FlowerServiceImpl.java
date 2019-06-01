//package com.self.entertainment.course.service.impl;
//
//import com.self.entertainment.course.common.ResponseData;
//import com.self.entertainment.course.common.TempFile;
//import com.self.entertainment.course.dao.FlowerRepository;
//import com.self.entertainment.course.dao.entity.Flower;
//import com.self.entertainment.course.service.FlowerService;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.io.IOUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.stereotype.Service;
//import org.apache.commons.io.FileUtils;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.Base64;
//
///**
// * @author AmazingZ
// * @date 2019/6/1 16:56
// */
//@Slf4j
//@Service
//public class FlowerServiceImpl implements FlowerService {
//
//    @Autowired
//    FlowerRepository flowerRepository;
//
//    @Override
//    public ResponseData<Flower> addFlower(Flower flower, MultipartFile file) {
//
//
//        String fileName = file.getOriginalFilename();
//        String type=".jpg";
//        if (fileName != null) {
//            type=fileName.substring(fileName.lastIndexOf(".")+1);
//        }
//        file.transferTo();
//
//        byte[] picData= Base64.getDecoder().decode(pic);
//        File picFile = new File(TempFile.getInstance().getFile(), flower.getFlowerName());
//        try {
//            FileUtils.writeByteArrayToFile(picFile,picData);
//        } catch (IOException e) {
//            log.error("存图片失败",e);
//        }
//        if(flowerRepository.existsByFlowerName(flower.getFlowerName())){
//            return ResponseData.fail("花名重复");
//        }
//        return  ResponseData.success(flowerRepository.save(flower));
//    }
//
//    @Override
//    public ResponseData<Flower> updateFlower(Flower flower) {
//        return ResponseData.success(flowerRepository.save(flower));
//    }
//
//    @Override
//    public ResponseData<String>  deleteFlower(Long flowerId) {
//        flowerRepository.deleteByFlowerId(flowerId);
//        return ResponseData.success("");
//    }
//
//    @Override
//    public ResponseData<Page<Flower>> getAllFlowers() {
//        return null;
//    }
//
//    @Override
//    public ResponseData<Flower> findByFlowerName(String name) {
//        return null;
//    }
//}
