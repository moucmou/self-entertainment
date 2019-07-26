package cn.example.amazingt.dto;

/**
 * @author AmazingZ
 * @date 2018/9/15 15:07
 */
public class LoginDto extends PageDto {

    private static final long serialVersionUID = 1L;

    private String loginName;//登录用户名称
    private String password;//登录密码
    private String salt;//登录盐值

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
