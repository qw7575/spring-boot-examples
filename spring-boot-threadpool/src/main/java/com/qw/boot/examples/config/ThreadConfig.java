package com.qw.boot.examples.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * ����
 *
 * @author: 72153169--����
 * @date: 2021/9/30 16:08
 * @Copyright (c) 2021/9/30 vivo Tech
 */

@Configuration
@ComponentScan("com.qw.boot.examples.service")
@EnableAsync
public class ThreadConfig  {
    /**
     * ִ����Ҫ�����̳߳أ������������һ���̳߳�
     *
     * @return
     */

    // �����Ӵ�СС��corePoolSize�����½��̣߳�����������
    // �����Ӵ�С����corePoolSize�����������workQueue(QueueCapacity)�У�������Ŀ����߳̾�ȥworkQueue��ȡ���񲢴���
    // ��workQueue�Ų�������ʱ�����½��߳���أ�����������������Ӵ�С�ŵ���maximumPoolSize������RejectedExecutionHandler�����ܾ�����
    // �����ӵ��߳�������corePoolSizeʱ��������̻߳�ȴ�keepAliveTime��ʱ�䣬���������ɴ������������

    @Bean("getExecutor")
    public Executor getExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //���ú����߳���
        executor.setCorePoolSize(1000);
        //��������߳���
        executor.setMaxPoolSize(10000);
        //�̳߳���ʹ�õĻ������
        executor.setQueueCapacity(7500);
        //�����߳���
        executor.setThreadNamePrefix("service-Async");
        //���ö����̵߳ȴ���ʱ�䣬��λ����
        //executor.setKeepAliveSeconds();
        // ��ʼ���߳�
        executor.initialize();
        return executor;
    }
}
