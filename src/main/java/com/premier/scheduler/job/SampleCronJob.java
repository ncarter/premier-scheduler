package com.premier.scheduler.job;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.stream.IntStream;


@DisallowConcurrentExecution
public class SampleCronJob extends QuartzJobBean {
  private static final Logger logger = LoggerFactory.getLogger(SampleCronJob.class);

  @Override
  protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
    logger.info("SampleCronJob Start................");
    IntStream.range(0, 10).forEach(i -> {
      logger.info("Counting - {}", i);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        logger.error(e.getMessage(), e);
      }
    });
    logger.info("SampleCronJob End................");
  }
}
