package com.self.entertainment.course.dto;

import com.self.entertainment.course.dao.entity.OderDetail;
import com.self.entertainment.course.dao.entity.Order;
import lombok.Data;

import java.util.List;

@Data
public class OrderDto extends Order {

    private List<OderDetail> oderDetails;

}
