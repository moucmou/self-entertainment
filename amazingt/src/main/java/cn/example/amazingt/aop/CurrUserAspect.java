package cn.example.amazingt.aop;

import cn.example.amazingt.annotation.CurrUser;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @author AmazingZ
 * @date 2018/9/15 17:44
 */

@Component
@Aspect
//@EnableAspectJAutoProxy
public class CurrUserAspect {

    @Pointcut("execution(public * cn.example.amazingt.controller.*.*(..))")
    public void CurrUserPointcut() {
    }
    @Around("CurrUserPointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        return joinPoint.proceed();
    }
    //后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
    @After("CurrUserPointcut()")
    public void after(JoinPoint jp){
        System.out.println("方法最后执行.....");
    }
}
