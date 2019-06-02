package com.self.entertainment.course.utils;

import org.springframework.data.domain.PageRequest;

import java.util.Objects;

public class PageUtils {

    public static PageRequest of(Integer pageNo,Integer pageSize){

        if(Objects.isNull(pageNo)||pageNo<0){
            pageNo=0;
        }
        if(Objects.isNull(pageSize)||pageSize<0){
            pageSize=30;
        }
        return PageRequest.of(pageNo,pageSize);
    }
}
