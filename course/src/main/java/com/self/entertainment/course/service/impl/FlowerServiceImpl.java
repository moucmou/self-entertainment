package com.self.entertainment.course.service.impl;

import com.self.entertainment.course.common.ResponseData;
import com.self.entertainment.course.utils.*;
import com.self.entertainment.course.dao.FlowerRepository;
import com.self.entertainment.course.dao.entity.Flower;
import com.self.entertainment.course.service.FlowerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * @author AmazingZ
 * @date 2019/6/1 16:56
 */
@Slf4j
@Service
public class FlowerServiceImpl implements FlowerService {

    public static final String PREFIX = "/storage/";
    @Autowired
    FlowerRepository flowerRepository;

    @Override
    public ResponseData<Flower> addFlower(Flower flower, MultipartFile file) {
        Flower newFlower=new Flower();
        if(Objects.nonNull(flower.getFlowerId())){
           Flower newflower=flowerRepository.findById(flower.getFlowerId()).get();
            CopyBeanUtils.copyProperties(newflower,flower);
        }
        File picFile = new File(TempFile.getInstance().getFile(),String.valueOf(flower.getFlowerId()) );
        try {
            FileUtils.copyInputStreamToFile(file.getInputStream(), picFile);
        } catch (Exception e) {
            log.error("存图片失败", e);
        }
        flowerRepository.save(flower);
        flower.setCreateTime(System.currentTimeMillis());
        flower.setPicUrl(PREFIX + flower.getFlowerId());
        return ResponseData.success(flower);
    }



    @Override
    public ResponseData<String> deleteFlower(Long flowerId) {
        PicUtils.deletePic(String.valueOf(flowerId));
        flowerRepository.deleteByFlowerId(flowerId);
        return ResponseData.success("");
    }

    @Override
    public ResponseData<Page<Flower>> getAllFlowers(Integer pageNo, Integer pageSize) {
        return ResponseData.success(flowerRepository.findAll(PageRequest.of(Objects.isNull(pageNo) ? 0 : pageNo, Objects.isNull(pageSize) ? 20: pageSize, new Sort(Sort.Direction.DESC,
                "createTime"))));
    }

    @Override
    public ResponseData<Page<Flower>> findByFlowerName(String name, Integer pageNo, Integer pageSize) {
        return ResponseData.success(flowerRepository.findByFlowerNameLike(SqlUtils.concatLike(name, SqlLike.DEFAULT),
                PageUtils.of(pageNo, pageSize)));
    }

    @Override
    public ResponseData<List<Flower>> findByFlowerIds(Long[] flowerId) {
        return ResponseData.success(flowerRepository.findByFlowerIdIn(flowerId));
    }
}
