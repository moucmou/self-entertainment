package cn.example.amazingt.service.impl;

import cn.example.amazingt.dto.DeviceDto;
import cn.example.amazingt.entity.Device;
import cn.example.amazingt.entity.User;
import cn.example.amazingt.service.IDeviceService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author AmazingZ
 * @date 2018/9/16 23:35
 */
@Service("IDeviceOtherServiceImpl")
public class IDeviceOtherServiceImpl implements IDeviceService {
    @Override
    public Device autoSave(DeviceDto deviceDto, User user) {
        return null;
    }

    @Override
    public Device save(Device device) {
        return null;
    }

    @Override
    public int deleteByIndexCode(String IndexCode) {
        return 0;
    }

    @Override
    public int updateByIndexCode(DeviceDto deviceDto) {
        return 0;
    }

    @Override
    public Page<Device> page(DeviceDto deviceDto, User user) {
        return null;
    }

    @Override
    public List<Device> findAll() {
        return null;
    }

    @Override
    public Device findOne(String indexCode) {
        return null;
    }

    @Override
    public int updateStatuByIndexCode(DeviceDto deviceDto) {
        return 0;
    }

    @Override
    public List<String> listAllIp() {
        return null;
    }

    @Override
    public Page<Device> selectByName(DeviceDto deviceDto,User user) {
        return null;
    }
}
