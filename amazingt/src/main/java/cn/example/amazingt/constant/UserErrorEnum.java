package cn.example.amazingt.constant;

/**
 * @author AmazingZ
 * @date 2018/9/15 15:01
 */
public enum UserErrorEnum {

    PARAM_EMPTY("0x00212000", "请求参数不能为空"),
    USERNAME_EMPTY("0x00212020", "用户名不能为空"),
    PASSWORD_EMPTY("0x00212021", "登录密码不能为空"),
    USERNAME_EXSIT("0x00212024", "该用户名已被注册"),
    USERNAME_NOT_EXSIT("0x00212024", "登录用户名不存在"),
    PASSWORD_ERROR("0x00212026", "用户密码错误"),
    NOT_LOGIN("0x00212028", "当前无用户登录"),
    SUCCESS("0x00212099", "操作成功");

    private String code;//编码值
    private String message;//描述信息

    private UserErrorEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
