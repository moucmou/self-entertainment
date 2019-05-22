package cn.example.amazingt.util;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * @author AmazingZ
 * @date 2018/9/15 15:02
 */

//@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseData {

//    private static final long serialVersionUID = 1L;
    public final static String SUCCESS = "0";

    public final static String ERROR = "-1";

    public final static String WARN = "-2";


    /*
     * 请求是否成功
     */
    private String code;

    /*
     * 错误消息
     */
    private String msg ;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /*

     * 请求结果
     */
//    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;

    /**
     * 空构造方法，提供json反序列化用
     */
    public ResponseData() {

    }

    /**
     * 请求数据成功，没有返回消息体
     *
     * @param code
     */
    private ResponseData(String code) {
        this.code = code;
    }

    /**
     * 请求数据成功，有返回消息体
     *
     * @param data
     * @return
     */
    public ResponseData(String code, Object data) {
        this.code = code;
        this.data = data;
    }

     public ResponseData(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

     public ResponseData(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


}
