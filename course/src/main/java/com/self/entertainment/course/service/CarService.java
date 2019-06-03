package com.self.entertainment.course.service;

import com.self.entertainment.course.common.ResponseData;
import com.self.entertainment.course.dao.entity.Car;
import org.springframework.data.domain.Page;

public interface CarService {

    /**
     * 新增花
     * @return
     */
    ResponseData<Car>  addItem(Long flowerId, Integer number );
    /**
     * 减花
     */
    ResponseData<String>  delItem(Long flowerId);
    /**
     * 结算   生成订单
     */
    ResponseData<String>  account(Long [] flowerIds);

    /**
     * 获取购物车
     */
    ResponseData<Page<Car>>  getItem(Integer pageNo,Integer pageSize);

}
