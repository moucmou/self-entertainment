package cn.example.amazingt.entity;

import javax.persistence.*;
import java.util.List;

/**
 * @author AmazingZ
 * @date 2018/9/15 14:34
 */
@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "i_id", nullable = false,unique = true)
    private Integer id;
    @Column(name="u_user_name",nullable = false)
    private String userName;  //用户名N
    @Column(name="u_password")
//    @Transient
    private String password;
    @Column(name="u_index_code")  //用户唯一标识
    private String indexCode;
    @Transient
    private List<String> list;  //设备标识

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIndexCode() {
        return indexCode;
    }

    public void setIndexCode(String indexCode) {
        this.indexCode = indexCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
