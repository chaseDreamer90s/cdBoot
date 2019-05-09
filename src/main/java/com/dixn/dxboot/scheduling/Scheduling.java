package com.dixn.dxboot.scheduling;

import com.dixn.dxboot.redis.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

import java.util.Date;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @version v1.0
 * @Description：Send alarm info to tcdp
 * @projectName：FCS
 * @packageName： com.dixn.alarm
 * @ClassName：zhaoxu
 * @author：zhaoxu
 * @createTime：2018/8/31 16:12
 * @upate：zhaoxu
 * @updateDate：2018/8/31 16:12
 * @remark：
 */
@Configuration
@Slf4j
public class Scheduling implements SchedulingConfigurer {

	@Autowired
    RedisUtil redisUtil;

	@Value("${alarm_queue_cron}")
	private String cron;

	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		/*taskRegistrar.setTaskScheduler(taskExecutor());
		taskRegistrar.getScheduler().schedule(() -> {
            System.out.println("Scheduling......");
        }, new CronTrigger(cron));*/
		taskRegistrar.setTaskScheduler(taskScheduler());
		taskRegistrar.getScheduler().schedule(() ->
				log.info("SchedulingConfigurer定时任务：" + new Date()),
				new CronTrigger("0/3 * * * * ?"));
	}

	/*@Bean("taskExecutor")
	public TaskScheduler taskExecutor() {
		ThreadPoolTaskScheduler executor = new ThreadPoolTaskScheduler();
		executor.setPoolSize(20);
		executor.setThreadNamePrefix("task-Executor-");
		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		executor.setWaitForTasksToCompleteOnShutdown(true);
		// wait times
		executor.setAwaitTerminationSeconds(60);
		return executor;
	}*/
/*	@Bean("taskExecutor")
	public TaskScheduler taskExecutor() {
		ThreadPoolTaskScheduler executor = new ThreadPoolTaskScheduler();
		executor.initialize();
		executor.setPoolSize(20);
		executor.setThreadNamePrefix("oKong-Executor-");
		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		//调度器shutdown被调用时等待当前被调度的任务完成
		executor.setWaitForTasksToCompleteOnShutdown(true);
		//等待时长
		executor.setAwaitTerminationSeconds(60);
		return executor;
	}*/

	@Bean(destroyMethod = "shutdown")
	public ThreadPoolTaskScheduler taskScheduler() {
		ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
		scheduler.initialize();
		scheduler.setPoolSize(20);
		scheduler.setThreadNamePrefix("task-");
		scheduler.setAwaitTerminationSeconds(60);
		scheduler.setWaitForTasksToCompleteOnShutdown(true);
		return scheduler;
	}

}
