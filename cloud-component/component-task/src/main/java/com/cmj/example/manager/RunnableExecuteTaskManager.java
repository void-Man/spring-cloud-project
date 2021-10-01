package com.cmj.example.manager;

import com.cmj.example.task.ExecuteTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author mengjie_chen
 * @description
 * @date 2021/9/30
 */
@Component
@Slf4j
public class RunnableExecuteTaskManager extends AbstractExecuteTaskManager<ExecuteTask> {

    @Resource
    private ExecutorServiceManager executorServiceManager;

    @Override
    public void addTask(ExecuteTask task) {
        super.QUEUE.offer(task);
    }

    @Override
    protected void handlerTask() {
        ExecuteTask task;
        try {
            task = QUEUE.poll(DEFAULT_MAX_WAIT_TIME, TimeUnit.SECONDS);
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
