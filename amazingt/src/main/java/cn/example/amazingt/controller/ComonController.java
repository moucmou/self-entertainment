package cn.example.amazingt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author AmazingZ
 * @date 2018/9/16 18:56
 */
@Controller
@RequestMapping("/web")
public class ComonController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }


    @RequestMapping("/addDevice")
    public String addDevice() {
        return "addDevice";
    }

    @RequestMapping("/findAllDevice")
    public String findALlDevice() {
        return "findAllDevices";
    }


}
