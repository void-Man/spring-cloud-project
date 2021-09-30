package com.cmj.example.manager;

import com.cmj.example.utils.factory.DefaultBlockQueueFactory;
import com.cmj.example.utils.thread.ExecuteTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * @author mengjie_chen
 * @description
 * @date 2021/9/30
 */
@Component
@Slf4j
public class ExecuteTaskManager implements Runnable {

    private static final BlockingDeque<ExecuteTask> QUEUE = DefaultBlockQueueFactory.creaLinkedBlockQueue();

    private static final int MAX_WAIT_TIME = 3;

    @Resource
    private ExecutorServiceManager executorServiceManager;


    public ExecuteTaskManager() {
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (true) {
            handlerTask();
        }
    }

    public void add(ExecuteTask task) {
        QUEUE.offer(task);
    }

    private void handlerTask() {
        ExecuteTask task;
        try {
            task = QUEUE.poll(MAX_WAIT_TIME, TimeUnit.SECONDS);
            if (Objects.isNull(task)) {
                return;
            }
        } catch (InterruptedException e) {
            log.error("取出任务出现异常 -----> {}", e.toString());
            return;
        }
        doHandler(task);
    }

    private void doHandler(ExecuteTask task) {
        executorServiceManager.getExecutorServiceByName(ExecutorServiceManager.RUNNABLE)
                .submit(task::execute);
    }
}
