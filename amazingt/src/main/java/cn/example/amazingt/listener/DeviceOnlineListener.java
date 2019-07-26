package cn.example.amazingt.listener;

import cn.example.amazingt.dto.DeviceDto;
import cn.example.amazingt.entity.Device;
import cn.example.amazingt.events.DeviceEvent;
import cn.example.amazingt.service.IDeviceService;
import org.omg.CORBA.portable.IDLEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author AmazingZ
 * @date 2018/9/15 20:24
 */

/**
 * 订阅者
 */
@Component
public class DeviceOnlineListener implements ApplicationListener<DeviceEvent> {
    @Autowired
    @Qualifier("IDeviceServiceImpl")
    IDeviceService iDeviceService;

    /**
     * 一类事件，只对离线感到兴趣
     *
     * @param event
     */
    @Override
    public void onApplicationEvent(DeviceEvent event) {

        Logger logger = LoggerFactory.getLogger(DeviceOnlineListener.class);
        if (event.getEventTypeId() == 1) {
            logger.info(event.getDevice().getDeviceName() + "在线");
            iDeviceService.save(event.getDevice());
        }

    }
}
