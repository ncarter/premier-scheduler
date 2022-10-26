package com.premier.scheduler.controller;

import com.premier.scheduler.entity.SchedulerJobInfo;
import com.premier.scheduler.model.Message;
import com.premier.scheduler.service.SchedulerJobService;
import org.quartz.SchedulerException;
import org.quartz.SchedulerMetaData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class JobController {
  private static final Logger logger = LoggerFactory.getLogger(JobController.class);

  private final SchedulerJobService scheduleJobService;

  public JobController(final SchedulerJobService scheduleJobService) {
    this.scheduleJobService = scheduleJobService;
  }

  @RequestMapping(value = "/saveOrUpdate", method = {RequestMethod.GET, RequestMethod.POST})
  public Object saveOrUpdate(SchedulerJobInfo job) {
    logger.info("params, job = {}", job);
    Message message = Message.failure();
    try {
      scheduleJobService.saveOrupdate(job);
      message = Message.success();
    } catch (Exception e) {
      message.setMsg(e.getMessage());
      logger.error("updateCron ex:", e);
    }
    return message;
  }

  @RequestMapping("/metaData")
  public Object metaData() throws SchedulerException {
    SchedulerMetaData metaData = scheduleJobService.getMetaData();
    return metaData;
  }

  @RequestMapping("/getAllJobs")
  public Object getAllJobs() throws SchedulerException {
    List<SchedulerJobInfo> jobList = scheduleJobService.getAllJobList();
    return jobList;
  }

  @RequestMapping(value = "/runJob", method = {RequestMethod.GET, RequestMethod.POST})
  public Object runJob(SchedulerJobInfo job) {
    logger.info("params, job = {}", job);
    Message message = Message.failure();
    try {
      scheduleJobService.startJobNow(job);
      message = Message.success();
    } catch (Exception e) {
      message.setMsg(e.getMessage());
      logger.error("runJob ex:", e);
    }
    return message;
  }

  @RequestMapping(value = "/pauseJob", method = {RequestMethod.GET, RequestMethod.POST})
  public Object pauseJob(SchedulerJobInfo job) {
    logger.info("params, job = {}", job);
    Message message = Message.failure();
    try {
      scheduleJobService.pauseJob(job);
      message = Message.success();
    } catch (Exception e) {
      message.setMsg(e.getMessage());
      logger.error("pauseJob ex:", e);
    }
    return message;
  }

  @RequestMapping(value = "/resumeJob", method = {RequestMethod.GET, RequestMethod.POST})
  public Object resumeJob(SchedulerJobInfo job) {
    logger.info("params, job = {}", job);
    Message message = Message.failure();
    try {
      scheduleJobService.resumeJob(job);
      message = Message.success();
    } catch (Exception e) {
      message.setMsg(e.getMessage());
      logger.error("resumeJob ex:", e);
    }
    return message;
  }

  @RequestMapping(value = "/deleteJob", method = {RequestMethod.GET, RequestMethod.POST})
  public Object deleteJob(SchedulerJobInfo job) {
    logger.info("params, job = {}", job);
    Message message = Message.failure();
    try {
      scheduleJobService.deleteJob(job);
      message = Message.success();
    } catch (Exception e) {
      message.setMsg(e.getMessage());
      logger.error("deleteJob ex:", e);
    }
    return message;
  }
}
