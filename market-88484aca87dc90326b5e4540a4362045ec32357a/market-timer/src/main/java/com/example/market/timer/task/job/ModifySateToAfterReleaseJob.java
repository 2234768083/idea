package com.example.market.timer.task.job;

import com.example.market.timer.task.handler.UserPageHandler;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang
 * date: 2019/6/24 15:37
 * description:
 */
@Slf4j
@Component
public class ModifySateToAfterReleaseJob implements Job {

    @Resource(name = "modifySateToAfterReleaseHandler")
    private UserPageHandler modifySateToAfterReleaseHandler;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        modifySateToAfterReleaseHandler.handle();
    }
}
