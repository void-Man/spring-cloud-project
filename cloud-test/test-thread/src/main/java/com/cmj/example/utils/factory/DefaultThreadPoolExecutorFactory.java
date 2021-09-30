package com.cmj.example.utils.factory;

import cn.hutool.core.thread.RejectPolicy;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author mengjie_chen
 * @description
 * @date 2021/9/30
 */
public class DefaultThreadPoolExecutorFactory {

    private static final int DEFAULT_CORE_NUMS = 8;

    private static final int DEFAULT_MAX_NUMS = 16;

    private static final Long KEEP_ALIVE_TIME = 60L;

    public static ThreadPoolExecutor createRunnableThreadPoolExecutor() {
        return createThreadPoolExecutor(DEFAULT_CORE_NUMS, DEFAULT_MAX_NUMS);
    }

    private static ThreadPoolExecutor createThreadPoolExecutor(int defaultCoreNums, int defaultMaxNums) {
        return new ThreadPoolExecutor(defaultCoreNums
                , defaultMaxNums
                , KEEP_ALIVE_TIME
                , TimeUnit.SECONDS
                , DefaultBlockQueueFactory.creaLinkedBlockQueue()
                , DefaultThreadFactory.createDefaultThreadFactory("RunnableTask")
                , RejectPolicy.ABORT.getValue());
    }

}
