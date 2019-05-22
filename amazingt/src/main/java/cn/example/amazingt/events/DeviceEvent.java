package cn.example.amazingt.events;

import cn.example.amazingt.entity.Device;
import org.springframework.context.ApplicationEvent;

import java.util.List;

/**
 * @author AmazingZ
 * @date 2018/9/15 20:25
 */
public class DeviceEvent extends ApplicationEvent {

    private Device device;
    private int eventTypeId;
    public DeviceEvent(Device device) {
        super(device);
        this.device=device;
    }
    public DeviceEvent(int eventType,Device device) {
        super(device);
        this.eventTypeId=eventType;
        this.device=device;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public int getEventTypeId() {
        return eventTypeId;
    }

    public void setEventTypeId(int eventTypeId) {
        this.eventTypeId = eventTypeId;
    }
}
