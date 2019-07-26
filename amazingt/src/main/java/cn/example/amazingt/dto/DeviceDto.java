package cn.example.amazingt.dto;

/**
 * @author AmazingZ
 * @date 2018/9/15 17:35
 */
public class DeviceDto extends PageDto {

    private static final long serialVersionUID = 1L;
    private String deviceName;
    private String ip;
    private String indexCode;
    private String timeNote;
    private int online;

    public int getOnline() {
        return online;
    }

    public void setOnline(int online) {
        this.online = online;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public String getTimeNote() {
        return timeNote;
    }

    public void setTimeNote(String timeNote) {
        this.timeNote = timeNote;
    }

    public void setDeviceName(String deviceName) {

        this.deviceName = deviceName;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getIndexCode() {
        return indexCode;
    }

    public void setIndexCode(String indexCode) {
        this.indexCode = indexCode;
    }
}
