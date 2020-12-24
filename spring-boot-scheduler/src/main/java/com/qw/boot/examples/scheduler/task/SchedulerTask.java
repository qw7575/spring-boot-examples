package com.qw.boot.examples.scheduler.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by summer on 2016/12/1.
 */

@Component
public class SchedulerTask {

    private int count = 0;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");


    @Scheduled(cron = "*/6 * * * * ?")
    private void process() {
        System.out.println("this is scheduler task runing  " + (count++) + "。时间是：" + dateFormat.format(new Date()));
    }

}
