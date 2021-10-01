package com.cmj.example.manager;

import com.cmj.example.factory.DefaultBlockQueueFactory;

import java.util.concurrent.BlockingDeque;

/**
 * @author mengjie_chen
 * @description
 * @date 2021/10/1
 */
public abstract class AbstractExecuteTaskManager<T> implements ExecuteTaskManager<T> {

    protected final BlockingDeque<T> QUEUE = DefaultBlockQueueFactory.creaLinkedBlockQueue();

    protected static final int DEFAULT_MAX_WAIT_TIME = 3;

    public AbstractExecuteTaskManager() {
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (true) {
            handlerTask();
        }
    }

    protected abstract void handlerTask();
}
