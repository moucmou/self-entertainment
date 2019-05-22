package cn.example.amazingt.events;

import cn.example.amazingt.entity.Device;
import org.springframework.context.ApplicationEvent;

/**
 * @author AmazingZ
 * @date 2018/9/16 20:15
 */
public class OtherEvent extends ApplicationEvent {
    private String ip;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    private int eventTypeId;


    public OtherEvent(String  ip,int eventTypeId) {
        super(ip);
        this.ip=ip;
        this.eventTypeId=eventTypeId;

    }
    public int getEventTypeId() {
        return eventTypeId;
    }

    public void setEventTypeId(int eventTypeId) {
        this.eventTypeId = eventTypeId;
    }


}
