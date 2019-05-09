package com.dixn.dxboot.controller;

import com.dixn.dxboot.aop.annotation.Log;
import com.dixn.dxboot.jpa.dao.FcsDao;
import com.dixn.dxboot.jpa.entity.Fcs;
import com.dixn.dxboot.kafka.Message;
import com.dixn.dxboot.mybatis.mapper.TeFcsMapper;
import com.dixn.dxboot.mybatis.model.TeFcs;
import com.dixn.dxboot.quartz.Timer;
import com.dixn.dxboot.service.DroolsService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * ${DESCRIPTION}
 *
 * @author
 * @create 2018-11-19 18:14
 **/
@RestController
@RequestMapping("/test")
@Slf4j
@Api(tags="用户API")
public class TestController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private Gson gson = new GsonBuilder().create();

    /**
     * 注入任务调度器
     */
    @Autowired
    private Scheduler scheduler;

    @GetMapping(value = "/index/{id}/{name}")
    @ApiOperation(value="用户查询(ID)")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value="查询ID",required=true),
            @ApiImplicitParam(name="name",value="查询name",required=true)})
    @Log(value="请求了index方法")
    public String index(@PathVariable("id") String id, @PathVariable("name") String name) {

        Message message = new Message();
        message.setId(System.currentTimeMillis());
        message.setMsg(UUID.randomUUID().toString());
        message.setSendTime(LocalDateTime.now());
        log.info("+++++++++++++++++++++  message = {}", gson.toJson(message));
        kafkaTemplate.send("test2", gson.toJson(message));

        return name;
    }


    @GetMapping(value = "/timer")
    @ApiOperation(value="timer")
    public String timer(){
        //设置开始时间为1分钟后
        long startAtTime = System.currentTimeMillis() + 1000 * 6;
        //任务名称
        String name = UUID.randomUUID().toString();
        //任务所属分组
        String group = Timer.class.getName();
        //创建任务
        JobDetail jobDetail = JobBuilder.newJob(Timer.class).withIdentity(name, group).build();
        //创建任务触发器
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity(name, group).startAt(new Date(startAtTime)).build();
        //将触发器与任务绑定到调度器内
        try {
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return "ok";
    }

    @Autowired
    private DroolsService droolsService;

    @GetMapping("/showRults")
    public String showRults(){
        return droolsService.fireRule();
    }

    @Autowired
    private FcsDao fcsDao;

    @GetMapping("/showJpa")
    public String showJpa() {
        List<Fcs> all = fcsDao.findAll();
        System.out.println(all.size());
        return String.valueOf(all.size());
    }

    @Autowired
    TeFcsMapper teFcsMapper;

    @GetMapping("/showMybatis")
    public String showMybatis() {
        TeFcs teFcs = teFcsMapper.selectByPrimaryKey("798df8fbe7b711e88a8c002246209dcc");
//        teFcsMapper.deleteByPrimaryKey("d46fec47e66511e88a8c002246209dcc");
        return teFcs.getIpFcs();
    }
}
