package com.premier.scheduler.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "SCHEDULER_JOB_INFO")
public class SchedulerJobInfo {

  @Id
  @GeneratedValue
  private UUID jobId;
  private String jobName;
  private String jobGroup;
  private String jobStatus;
  private String jobClass;
  private String cronExpression;
  private String desc;
  private String interfaceName;
  private Long repeatTime;
  private Boolean cronJob;

  public UUID getJobId() {
    return jobId;
  }

  public void setJobId(UUID jobId) {
    this.jobId = jobId;
  }

  public String getJobName() {
    return jobName;
  }

  public void setJobName(String jobName) {
    this.jobName = jobName;
  }

  public String getJobGroup() {
    return jobGroup;
  }

  public void setJobGroup(String jobGroup) {
    this.jobGroup = jobGroup;
  }

  public String getJobStatus() {
    return jobStatus;
  }

  public void setJobStatus(String jobStatus) {
    this.jobStatus = jobStatus;
  }

  public String getJobClass() {
    return jobClass;
  }

  public void setJobClass(String jobClass) {
    this.jobClass = jobClass;
  }

  public String getCronExpression() {
    return cronExpression;
  }

  public void setCronExpression(String cronExpression) {
    this.cronExpression = cronExpression;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public String getInterfaceName() {
    return interfaceName;
  }

  public void setInterfaceName(String interfaceName) {
    this.interfaceName = interfaceName;
  }

  public Long getRepeatTime() {
    return repeatTime;
  }

  public void setRepeatTime(Long repeatTime) {
    this.repeatTime = repeatTime;
  }

  public Boolean getCronJob() {
    return cronJob;
  }

  public void setCronJob(Boolean cronJob) {
    this.cronJob = cronJob;
  }

  @Override
  public String toString() {
    return "SchedulerJobInfo{" +
      "jobId='" + jobId + '\'' +
      ", jobName='" + jobName + '\'' +
      ", jobGroup='" + jobGroup + '\'' +
      ", jobStatus='" + jobStatus + '\'' +
      ", jobClass='" + jobClass + '\'' +
      ", cronExpression='" + cronExpression + '\'' +
      ", desc='" + desc + '\'' +
      ", interfaceName='" + interfaceName + '\'' +
      ", repeatTime=" + repeatTime +
      ", cronJob=" + cronJob +
      '}';
  }
}
