package cn.example.amazingt.service;

import cn.example.amazingt.dto.DeviceDto;
import cn.example.amazingt.entity.Device;
import cn.example.amazingt.entity.User;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author AmazingZ
 * @date 2018/9/15 18:27
 */
public interface IDeviceService {
    /**
     * 新增设备
     * @param deviceDto
     * @return
     */
   Device autoSave(DeviceDto deviceDto,User user);

    /**
     * 修改device状态
     * @param device
     * @return
     */
   Device save(Device device);

    /**
     * 根据设备indexCode删除设备
     * @param IndexCode
     * @return
     */
   int deleteByIndexCode(String IndexCode);

    /**
     * 更新设备
     * @param deviceDto
     * @return
     */
   int updateByIndexCode(DeviceDto deviceDto);

    /**
     * 查询设备并分页
     * @param deviceDto
     * @return
     */
    Page<Device> page(DeviceDto deviceDto,User user);

    /**
     * 累出所有的设备
     * @return
     */
    List<Device> findAll();

    /**
     * 查看详情
     * @return
     */
    Device findOne(String indexCode);

    /**
     * 更新设备状态
     * @param deviceDto
     * @return
     */
    int updateStatuByIndexCode(DeviceDto deviceDto);

    /**
     * 查询所有的ip
     * @return
     */
    List<String> listAllIp();
    /**
     * 根据设备名查询
     * @return
     */
    Page<Device> selectByName(DeviceDto deviceDto,User user);
}
