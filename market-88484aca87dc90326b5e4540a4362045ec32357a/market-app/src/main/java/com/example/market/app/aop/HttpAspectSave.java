package com.example.market.app.aop;

import com.example.market.common.mysql.service.UserLogService;
import com.example.market.security.aop.AbsHttpAspectSave;
import com.example.market.security.aop.AbsHttpAspectSave;
import com.example.market.security.aop.SaveLog;
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
public class HttpAspectSave extends AbsHttpAspectSave {

    public HttpAspectSave(UserLogService userLogService) {
        super(userLogService);
    }

    /**
     * 切入点
     */
    @Pointcut("execution( * com.example.market.app.controller..*.*(..)) && @annotation(logs)")
    public void aopPointCut(SaveLog logs) {

    }


}
