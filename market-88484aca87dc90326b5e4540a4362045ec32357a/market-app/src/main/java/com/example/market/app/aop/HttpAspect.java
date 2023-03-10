package com.example.market.app.aop;

import com.example.market.security.aop.AbsHttpAspect;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/8/10 16:29
 * description:
 */
@Aspect
@Component
public class HttpAspect extends AbsHttpAspect {
    /**
     * 切入点
     */
    @Pointcut("execution( * com.example.market.app.controller..*.*(..))")
    public void aopPointCut() {

    }


}
