package com.dixn.dxboot.quartz;

import org.springframework.boot.autoconfigure.quartz.SchedulerFactoryBeanCustomizer;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * @Description：Scheduler Customizer
 * @projectName：dxboot
 * @packageName： com.dixn.dxboot.quartz
 * @ClassName：SchedulerCustomizer
 * @author：zhaoxu
 * @createTime：2018/11/19 20:18
 * @upate：zhaoxu
 * @updateDate：2018/11/19 20:18
 * @remark：
 * @version v1.0
 */
@Configuration
@EnableScheduling
public class SchedulerCustomizer implements SchedulerFactoryBeanCustomizer {
    @Override
    public void customize(SchedulerFactoryBean schedulerFactoryBean) {
        schedulerFactoryBean.setStartupDelay(2);
        schedulerFactoryBean.setAutoStartup(true);
        schedulerFactoryBean.setOverwriteExistingJobs(true);
    }
}
