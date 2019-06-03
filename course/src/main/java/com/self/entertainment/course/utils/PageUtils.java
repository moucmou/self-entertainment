package com.self.entertainment.course.utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PageUtils {

    private PageUtils() {
    }

    ;
    public static final Integer DEFAULT_PAGE_NO = 1;
    public static final Integer DEFAULT_PAGE_SIZE = 10;

    public static Pageable buildPageRequest(Integer pageNo, Integer pageSize, Sort sort) {
        if (pageNo == null || pageNo < 1) {
            pageNo = DEFAULT_PAGE_NO;
        }
        if (pageSize == null || pageSize < 1) {
            pageSize = DEFAULT_PAGE_SIZE;
        }
        if (sort == null) {
            return new PageRequest(pageNo - 1, pageSize);
        }
        return new PageRequest(pageNo - 1, pageSize, sort);
    }
}
