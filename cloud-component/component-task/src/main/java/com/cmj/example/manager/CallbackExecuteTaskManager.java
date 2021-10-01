package com.cmj.example.manager;

import com.cmj.example.task.CallbackTask;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListeningExecutorService;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author mengjie_chen
 * @description
 * @date 2021/10/1
 */
@Component
@Slf4j
public class CallbackExecuteTaskManager extends AbstractExecuteTaskManager<CallbackTask<?>> {

    @Resource
    private ExecutorServiceManager executorServiceManager;

    @Override
    protected void handlerTask() {
        CallbackTask<?> task;
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

    @Override
    public void addTask(CallbackTask<?> task) {
        super.QUEUE.offer(task);
    }


    private <T> void doHandler(CallbackTask<T> task) {
        ListeningExecutorService executorService = executorServiceManager.getExecutorServiceByName(ExecutorServiceManager.CALLBACK);
        Futures.addCallback(executorService.submit(task::execute), new FutureCallback<T>() {
            @Override
            public void onSuccess(@Nullable T result) {
                task.onSuccess(result);
            }

            @Override
            public void onFailure(Throwable t) {
                task.onFailure(t);
            }
        }, executorService);
    }
}
