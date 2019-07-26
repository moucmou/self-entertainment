package cn.example.amazingt.entity;

import javax.persistence.*;
import java.util.List;

/**
 * @author AmazingZ
 * @date 2018/9/15 17:29
 */

@Entity
@Table(name = "tb_device")
public class Device {

    @Id
    @GeneratedValue
    @Column(name = "i_id", nullable = false, unique = true)
    private Integer id;
    @Column(name = "d_name")  //设备名称
    private String deviceName;
    @Column(name = "d_index_code")  //设备唯一标识
    private String indexCode;
    @Column(name = "d_ip")  //设备ip
    private String ip;
    @Column(name = "u_index_code")  //所属用户
    private String userIndexCode;
    @Column(name = "d_time_note")  //最后操作数据库时间
    private String timeNote;
    @Column(name = "d_online")
    private int online;  //0表示离线，1表示在线

    public int getOnline() {
        return online;
    }

    public void setOnline(int online) {
        this.online = online;
    }

    public String getTimeNote() {
        return timeNote;
    }

    public void setTimeNote(String timeNote) {
        this.timeNote = timeNote;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getIndexCode() {
        return indexCode;
    }

    public void setIndexCode(String indexCode) {
        this.indexCode = indexCode;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUserIndexCode() {
        return userIndexCode;
    }

    public void setUserIndexCode(String userIndexCode) {
        this.userIndexCode = userIndexCode;
    }
}
