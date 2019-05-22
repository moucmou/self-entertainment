package cn.example.amazingt.controller;

import cn.example.amazingt.annotation.CurrUser;
import cn.example.amazingt.constant.UserErrorEnum;
import cn.example.amazingt.dto.DeviceDto;
import cn.example.amazingt.entity.Device;
import cn.example.amazingt.entity.User;
import cn.example.amazingt.service.IDeviceService;
import cn.example.amazingt.service.IUserService;
import cn.example.amazingt.util.ResponseData;
import cn.example.amazingt.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author AmazingZ
 * @date 2018/9/15 17:26
 */
@RestController
@RequestMapping(value ="/api/devices")
public class DevicesRestController {

    @Autowired
    @Qualifier("IDeviceServiceImpl")
    IDeviceService iDeviceService;
    /**
     * 新增设备
     * @return
     */
    @RequestMapping(value="/addDevice",method =RequestMethod.POST)
    public ResponseData addDevice(@RequestBody DeviceDto deviceDto,@CurrUser User user){
        Device device=iDeviceService.autoSave(deviceDto,user);
        if(null == device)return new ResponseData(UserErrorEnum.NOT_LOGIN.getCode(),"操作失败",null);
        return new ResponseData(UserErrorEnum.SUCCESS.getCode(),"操作成功",null);

    };

    /**
     * 根据设备indexCode删除设备
     * @return
     */
    @RequestMapping(value="/deleteByIndexCode",method =RequestMethod.GET)
    public ResponseData deleteByIndexCode(@RequestParam("indexCode") String indexCode){
        iDeviceService.deleteByIndexCode(indexCode);
        return new ResponseData(UserErrorEnum.SUCCESS.getCode(),"操作成功",null);
    };

    /**
     * 根据设备indexCode修改设备
     * @return
     */
    @RequestMapping(value="/updateByIndexCode",method =RequestMethod.POST)
    public ResponseData updateByIndexCode(@RequestBody DeviceDto deviceDto){
        iDeviceService.updateByIndexCode(deviceDto);
        return new ResponseData(UserErrorEnum.SUCCESS.getCode(),"操作成功",null);
    };

    /**
     * 根据当前用户indexCode查询设备
     * @return
     */
    @RequestMapping(value="/findAllDevices",method =RequestMethod.GET)
    public ResponseData selectAll(@RequestBody DeviceDto deviceDto,@CurrUser User user){

       if(StringUtils.isEmpty(deviceDto.getPageNo())){
           deviceDto.setPageNo(0);
       }
       if(StringUtils.isEmpty(deviceDto.getPageSize())){
           deviceDto.setPageSize(30);
           }
        return new ResponseData(UserErrorEnum.SUCCESS.getCode(),"查询成功", iDeviceService.page(deviceDto,user));
    };


    @RequestMapping(value="/findOneDevice",method =RequestMethod.GET)
    public ResponseData selectOne(@RequestParam("indexCode")String indexCode){

        return new ResponseData(UserErrorEnum.SUCCESS.getCode(),"查询成功", iDeviceService.findOne(indexCode));
    };


}
