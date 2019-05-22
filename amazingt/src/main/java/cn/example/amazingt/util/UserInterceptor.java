package cn.example.amazingt.util;

import cn.example.amazingt.constant.UserErrorEnum;
import cn.example.amazingt.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * @author AmazingZ
 * @date 2018/9/15 11:54
 */
public class UserInterceptor implements HandlerInterceptor {
    private final static Logger logger = LoggerFactory.getLogger(UserInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        HttpSession session = httpServletRequest.getSession();

        //当前访问的路径  可以用来过滤实现权限过滤
        String contextPath=httpServletRequest.getContextPath();
        String  url=httpServletRequest.getServletPath();

        User user=(User)session.getAttribute("user");
        if(!StringUtils.isEmpty(user)){
            logger.info("当前登录的用户为："+user.getUserName());
                return true;
        }else{
            ObjectMapper mapper = new ObjectMapper();
//            CustomMapper customMapper=new CustomMapper();
            ResponseData x=new ResponseData(UserErrorEnum.NOT_LOGIN.getCode(), cn.example.amazingt.util.StringUtils.splice(
                    UserErrorEnum.NOT_LOGIN.getMessage()),null);
            String response = mapper.writeValueAsString( x);
            httpServletResponse.setContentType("application/json; charset=utf-8");
//            httpServletResponse.getWriter().append(response);
            httpServletResponse.sendRedirect("/users/login");
            logger.info("当前用户未登陆，跳转到登陆界面");
            return false;
        }
    }


}
