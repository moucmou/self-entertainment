package cn.example.amazingt.service.impl;

import cn.example.amazingt.dao.IDeviceRepository;
import cn.example.amazingt.dto.DeviceDto;
import cn.example.amazingt.entity.Device;
import cn.example.amazingt.entity.User;
import cn.example.amazingt.service.IDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import javax.persistence.criteria.Predicate;
import java.time.Instant;
import java.util.*;

/**
 * @author AmazingZ
 * @date 2018/9/15 18:26
 */
@Service("IDeviceServiceImpl")
public class IDeviceServiceImpl implements IDeviceService {
    @Autowired
    IDeviceRepository iDeviceRepository;
    @Override
    public Device autoSave(DeviceDto deviceDto,User user) {
        Device device=new Device();
        device.setDeviceName(deviceDto.getDeviceName());
        device.setIndexCode(deviceDto.getIndexCode());
        device.setIp(deviceDto.getIp());
        device.setIndexCode(UUID.randomUUID().toString().replace("-",""));
        if(user==null){
            return null;
        }
        device.setUserIndexCode(user.getIndexCode());
        device.setTimeNote(String.valueOf(Instant.now()));
        return iDeviceRepository.save(device);
    }

    @Override
    public int deleteByIndexCode(String indexCode) {
        return iDeviceRepository.deleteByIndexCode(indexCode);
    }

    @Override
    public int updateByIndexCode(DeviceDto deviceDto) {

        return iDeviceRepository.updateByIndexCode(deviceDto.getDeviceName(),deviceDto.getIp(),String.valueOf(Instant.now()),deviceDto.getIndexCode());
    }

    @Override
    public Page<Device> page(DeviceDto deviceDto,User user) {
        Specification<Device> specification = (root, query, cb) -> {
            List<Predicate> list = new ArrayList<>();
            if (null != user) {
                list.add(cb.equal(root.get("userIndexCode").as(String.class), user.getIndexCode()));
            }
            return query.where(list.toArray(new Predicate[list.size()])).getRestriction();
        };
        return iDeviceRepository.findAll(specification,  PageRequest.of(deviceDto.getPageNo() - 1, deviceDto.getPageSize(), Sort.Direction.DESC, "timeNote"));
    }
    public List<Device> findAll(){
        return iDeviceRepository.findAll();
    }

    @Override
    public Device findOne(String indexCode) {
        return iDeviceRepository.findDeviceByIndexCode(indexCode);
    }

    @Override
    public int updateStatuByIndexCode(DeviceDto deviceDto) {
        return iDeviceRepository.updateStatuByIndexCode(String.valueOf(Instant.now()),deviceDto.getIndexCode());
    }

    @Override
    public List<String> listAllIp() {
        List<Device> deviceList=iDeviceRepository.findAll();
        Set<String> ipList=new HashSet<>();
        for (Device device:deviceList){
            if(device.getOnline()==0){
            ipList.add(device.getIp());
            }
        }
        return new ArrayList<>(ipList);
    }

    @Override
    public Page<Device> selectByName(DeviceDto deviceDto,User user) {

        Specification<Device> specification = (root, query, cb) -> {
            List<Predicate> list = new ArrayList<>();
            if (null != user) {
                list.add(cb.equal(root.get("userIndexCode").as(String.class), user.getIndexCode()));
            }
            if(null!=deviceDto.getDeviceName())
            {
                list.add(cb.equal(root.get("deviceName").as(String.class), deviceDto.getDeviceName()));
            }
            return query.where(list.toArray(new Predicate[0])).getRestriction();
        };
        return iDeviceRepository.findAll(specification, PageRequest.of(deviceDto.getPageNo() - 1, deviceDto.getPageSize(), Sort.Direction.DESC, "timeNote"));
    }


    @Override
    public Device save(Device device){
       return iDeviceRepository.save(device);
    }
}
