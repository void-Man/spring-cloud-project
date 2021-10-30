package com.cmj.example.manager;

import cn.hutool.core.lang.Snowflake;
import com.alibaba.fastjson.JSONObject;
import com.cmj.example.base.TaskRecordBase;
import com.cmj.example.factory.DefaultBlockQueueFactory;
import com.cmj.example.mapper.TaskRecordBaseMapper;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.util.concurrent.BlockingDeque;

/**
 * @author mengjie_chen
 * @description
 * @date 2021/10/1
 */
@Slf4j
public abstract class AbstractExecuteTaskManager<T> implements ExecuteTaskManager<T> {

    protected final BlockingDeque<T> QUEUE = DefaultBlockQueueFactory.creaLinkedBlockQueue();

    protected static final int DEFAULT_MAX_WAIT_TIME = 3;

    @Resource
    private TaskRecordBaseMapper taskRecordBaseMapper;
    private volatile boolean stop = false;

    public AbstractExecuteTaskManager() {
        new Thread(this).start();
    }

    @Override
    public void addTask(T task) {
        if (!stop) {
            QUEUE.offer(task);
            return;
        }
        log.info("开始执行保存任务操作");
        taskRecordBaseMapper.insertSelective(TaskRecordBase.builder().taskId(new Snowflake().nextId()).payload(JSONObject.toJSONString(task)).build());
        log.info("保存任务成功");
    }

    @Override
    public void run() {
        while (true) {
            handlerTask();
        }
    }

    /**
     * 线程池是否关闭
     *
     * @param
     * @return boolean
     * @date 2021/10/31
     */
    public boolean stopped() {
        return stop;
    }

    /**
     * 线程池是否关闭
     *
     * @param
     * @return boolean
     * @date 2021/10/31
     */
    public void stop() {
        stop = true;
    }

    protected abstract void handlerTask();
}
