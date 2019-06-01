package com.self.entertainment.course.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

/**
 * @author AmazingZ
 * @date 2018/12/24 14:14
 */
@Data
@AllArgsConstructor(staticName="of")
public class ResponseData<T> {
    private static final long serialVersionUID = 5508864578970150888L;


    private String code; //处理结果业务代码
    private String msg;  //处理结果业务信息
    private T data;      //返回的数据


    /**
     * @param code 处理结果业务代码
     * @param msg  处理结果业务信息
     */
    public ResponseData(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static <T> ResponseData<T> success(T t) {
        return  ResponseData.of("0","SUCCESS",t);
    }

    public static <T> ResponseData<T> fail( String message) {
        return new ResponseData<>("1", message);
    }

    public static <T> ResponseData<T> error( String message) {
        return new ResponseData<>("-1", message);
    }

    public Optional<T> safeGetData() {
        return Optional.ofNullable(data);
    }

}
