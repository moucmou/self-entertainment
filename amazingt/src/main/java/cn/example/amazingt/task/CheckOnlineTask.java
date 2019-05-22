package cn.example.amazingt.task;

import cn.example.amazingt.entity.Device;
import cn.example.amazingt.events.DeviceEvent;
import cn.example.amazingt.events.OtherEvent;
import cn.example.amazingt.service.IDeviceService;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.InetAddress;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author AmazingZ
 * @date 2018/9/15 19:22
 */
@Component
public class CheckOnlineTask {


    private final static Logger logger = LoggerFactory.getLogger(CheckOnlineTask.class);

    @Autowired
    @Qualifier("IDeviceServiceImpl")
    private IDeviceService iDeviceService;
    @Autowired
    private ApplicationContext applicationContext;

    private Lock lock = new ReentrantLock();

    List<Device> offlineDeviceLists;

    /**
     * 定时任务 每隔5分钟检查一次设备是否掉线
     * ExecutorService executorService= Executors.newSingleThreadExecutor();
     * executorService.execute(() -> { });
     */
    @Scheduled(fixedDelay=1000*60*5, initialDelay = 3000)
    private void sync() {
        List<Device> allDeviceLists = iDeviceService.findAll();

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        allDeviceLists.stream().<Runnable>map(device -> () -> {
            checkDeviceOnline(device);
        }).forEach(executorService::execute);

    }
    private void checkDeviceOnline(Device device) {
        int timeOut = 3000;  //超时应该在3钞以上
        int status = 0;
        if (lock.tryLock()) {
            try {
        //        "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."
                String regIp="^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."
                        +"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
                        +"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
                        +"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";;

                Pattern pattern = Pattern.compile(regIp);
                if(Strings.isEmpty(device.getIp()) ){
                    logger.info(device.getDeviceName()+"没有设置ip");
                }else if(!pattern.matcher(device.getIp()).matches()){
                    logger.info("设备ip"+device.getIp()+"ip地址无效");
                }else {
                    status = InetAddress.getByName(device.getIp()).isReachable(timeOut) ? 1 : 0;
                    device.setOnline(status);
                    //事件发布,可以封装成不同的事件消息来通知不同的订阅者,或者同类事件有不同的事件类型
                    //一类事件多个监听者
                    applicationContext.publishEvent(new DeviceEvent(status,device));
                    //不同类事件
                    applicationContext.publishEvent(new OtherEvent(device.getIp(),0));
                }
            } catch (IOException e) {
                logger.info("定时检查设备是否离线失败" + e);
            } finally {
                lock.unlock();
            }

        }
    }

    public static void main(String[] args) {

        String regIp="^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\.";

//                +"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
//
//                +"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
//
//                +"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";
        Pattern pattern = Pattern.compile(regIp);
        Matcher matcher = pattern.matcher("10.33.29.154");
        System.out.println(matcher.matches());;

        try {
            for(int i=0;i<1;i++) {
                int x = InetAddress.getByName("123123").isReachable(3000) == true ? 1 : 0;
                System.out.println(x);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
