package cn.example.amazingt.events;

import cn.example.amazingt.entity.Device;
import org.springframework.context.ApplicationEvent;

/**
 * @author AmazingZ
 * @date 2018/9/16 21:20
 */
public class OtherDeviceEvent extends ApplicationEvent {

    private Device device;
    private int eventTypeId;
    public OtherDeviceEvent(Device device) {
        super(device);
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
