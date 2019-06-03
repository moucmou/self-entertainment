package com.self.entertainment.course.service.impl;

import com.self.entertainment.course.common.ResponseData;
import com.self.entertainment.course.dao.FlowerRepository;
import com.self.entertainment.course.dao.entity.Flower;
import com.self.entertainment.course.service.FlowerService;
import com.self.entertainment.course.utils.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * @author AmazingZ
 * @date 2019/6/1 16:56
 */
@Slf4j
@Service
public class FlowerServiceImpl implements FlowerService {

    public static final String PREFIX = "/anon/storage?picId=";
    @Autowired
    FlowerRepository flowerRepository;

    @Transactional
    @Override
    public ResponseData<Flower> addFlower(Flower flower, String file) {
        if (Objects.nonNull(flower.getFlowerId())) {
            Flower newFlower = flowerRepository.findById(flower.getFlowerId()).get();
            CopyBeanUtils.copyProperties(newFlower, flower);
        }
        flowerRepository.save(flower);
        File picFile = new File(TempFile.getInstance().getFile(), String.valueOf(flower.getFlowerId()));
        try {
            FileUtils.writeStringToFile(picFile, file, "UTF-8");
        } catch (Exception e) {
            log.error("存图片失败", e);
        }
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
        Page<Flower> page = flowerRepository.findAll(PageUtils.buildPageRequest(pageNo, pageSize, new Sort(Sort.Direction.DESC,
                "createTime")));
        for (Flower flower : page.getContent()) {
            File picFile = new File(TempFile.getInstance().getFile(), String.valueOf(flower.getFlowerId()));
            try {
                flower.setPicUrl(FileUtils.readFileToString(picFile,"UTF-8"));  ;
            } catch (IOException e) {
                log.error("读数据失败", e);
            }
        }
        return ResponseData.success(page);
    }

    @Override
    public ResponseData<Page<Flower>> findByFlowerName(String name, Integer pageNo, Integer pageSize) {
        return ResponseData.success(flowerRepository.findByFlowerNameLike(SqlUtils.concatLike(name, SqlLike.DEFAULT),
                PageUtils.buildPageRequest(pageNo, pageSize, null)));
    }

    @Override
    public ResponseData<List<Flower>> findByFlowerIds(Long[] flowerId) {
        return ResponseData.success(flowerRepository.findByFlowerIdIn(flowerId));
    }

    @Override
    public ResponseData<String> uploadPic(MultipartFile multipartFile) {
//

//        return ;
        return ResponseData.success("");
    }
}
