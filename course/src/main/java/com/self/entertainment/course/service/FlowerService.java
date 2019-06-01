package com.self.entertainment.course.service;

import com.self.entertainment.course.common.ResponseData;
import com.self.entertainment.course.dao.entity.Flower;
import org.springframework.data.domain.Page;

/**
 * @author AmazingZ
 * @date 2019/6/1 16:54
 */
public interface FlowerService {
    /**
     * 新增花产品
     * @param flower
     * @return
     */
    ResponseData<Flower> addFlower(Flower flower,String pic);

    /**
     * 修改花产品
     * @param flower
     * @return
     */
    ResponseData<Flower> updateFlower(Flower flower);

    /**
     * 删除花
     */
    ResponseData<String> deleteFlower(Long flowerId);

    /**
     * 获取所有的花
     */
    ResponseData<Page<Flower>> getAllFlowers( );

    /**
     * 根据花名获取花
     */
    ResponseData<Flower> findByFlowerName(String name);
}
