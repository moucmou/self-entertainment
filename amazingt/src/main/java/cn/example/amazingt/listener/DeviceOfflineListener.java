package cn.example.amazingt.listener;

import cn.example.amazingt.events.DeviceEvent;
import cn.example.amazingt.service.IDeviceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


/**
 * @author AmazingZ
 * @date 2018/9/16 21:22
 */
@Component
public class DeviceOfflineListener implements ApplicationListener<DeviceEvent> {

    @Autowired
    @Qualifier("IDeviceServiceImpl")
    IDeviceService iDeviceService;

    Logger logger=LoggerFactory.getLogger(DeviceOfflineListener.class);

    /**
     * 一类事件，只对在线感到兴趣
     * @param event
     */
    @Override
    public void onApplicationEvent(DeviceEvent event) {
        if(event.getEventTypeId()==0){
            iDeviceService.save(event.getDevice());
            logger.info(event.getDevice().getDeviceName()+"离线");
        }
    }
}
