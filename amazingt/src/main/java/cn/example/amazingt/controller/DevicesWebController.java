package cn.example.amazingt.controller;

import cn.example.amazingt.annotation.CurrUser;
import cn.example.amazingt.constant.UserErrorEnum;
import cn.example.amazingt.dto.DeviceDto;
import cn.example.amazingt.entity.Device;
import cn.example.amazingt.entity.User;
import cn.example.amazingt.service.IDeviceService;
import cn.example.amazingt.util.ResponseData;
import cn.example.amazingt.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author AmazingZ
 * @date 2018/9/16 19:34
 */

@Controller
@RequestMapping("/web/device")
public class DevicesWebController {

    @Autowired
    @Qualifier("IDeviceServiceImpl")
    IDeviceService iDeviceService;
    /**
     * 根据当前用户indexCode查询设备
     * @return
     */
    @RequestMapping(value="/findAllDevices",method =RequestMethod.GET)
    public String selectAll(@RequestParam(defaultValue="1")String pageNo,@CurrUser User user, Model model){
        DeviceDto deviceDto=new DeviceDto();
        deviceDto.setPageSize(20);
        deviceDto.setPageNo(1);
        if(null!=pageNo && Integer.valueOf(pageNo)>0){
            deviceDto.setPageNo(Integer.valueOf(pageNo));
        }
        model.addAttribute("pages",iDeviceService.page(deviceDto,user));
        return "findAllDevices";
    };
    /**
     * 根据当前用户indexCode查询设备
     * @return
     */
    @RequestMapping(value="/findDeviceOne",method =RequestMethod.GET)
    public String selectByName(@RequestParam(defaultValue="1")String pageNo,@RequestParam(defaultValue="1")String pageSize,
                               @RequestParam("deviceName")String deviceName,
                               @CurrUser User user, Model model){

        DeviceDto deviceDto=new DeviceDto();
        deviceDto.setPageSize(20);
        deviceDto.setPageNo(1);
        if(null!=pageNo && Integer.valueOf(pageNo)>0){
            deviceDto.setPageNo(Integer.valueOf(pageNo));
        }
        if(null!=pageNo && Integer.valueOf(pageNo)>0){
            deviceDto.setPageNo(Integer.valueOf(pageSize));
        }
        if(null!=deviceName){
            deviceDto.setDeviceName(deviceName);
        }
        model.addAttribute("pages",iDeviceService.selectByName(deviceDto,user));
        return "findAllDevices";
    };

    /**
     * 根据设备indexCode删除设备
     * @return
     */
    @RequestMapping(value="/deleteByIndexCode",method =RequestMethod.GET)
    public String deleteByIndexCode(@RequestParam("indexCode") String indexCode,Model model,@CurrUser User user)
                                    {
        iDeviceService.deleteByIndexCode(indexCode);
        DeviceDto deviceDto=new DeviceDto();
        deviceDto.setPageSize(30);
        deviceDto.setPageNo(1);
        model.addAttribute("pages",iDeviceService.page(deviceDto,user));
       return "redirect:findAllDevices";
    };


    /**
     * 新增设备
     * @return
     */
    @RequestMapping(value="/addDevice",method =RequestMethod.POST)
    public String addDevice( DeviceDto deviceDto,@CurrUser User user,Model model){


        String regIp="^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."

                +"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."

                +"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."

                +"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";
        Pattern pattern = Pattern.compile(regIp);
        Matcher matcher = pattern.matcher(deviceDto.getIp());
        if(!matcher.matches()){
            model.addAttribute("error","ip不合法");
            return "index";
        }

        List list= iDeviceService.listAllIp();

        if(list.contains(deviceDto.getIp()))
        {
            model.addAttribute("error","ip已被占用");
            return "index";
        }
        Device device=iDeviceService.autoSave(deviceDto,user);
//        if(null == device)return new ResponseData(UserErrorEnum.NOT_LOGIN.getCode(),"操作失败",null);

        deviceDto.setPageSize(30);
        deviceDto.setPageNo(1);
        model.addAttribute("pages",iDeviceService.page(deviceDto,user));
        return "redirect:findAllDevices";
//        return new ResponseData(UserErrorEnum.SUCCESS.getCode(),"操作成功",null);

    };
}
