package com.cmj.example.manager;

import com.cmj.example.utils.factory.DefaultThreadPoolExecutorFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/**
 * @author mengjie_chen
 * @description
 * @date 2021/9/30
 */
@Component
public class ExecutorServiceManager {
    public static final String RUNNABLE = "runnableThread";

    private static final Map<String, ExecutorService> EXECUTOR_MANAGER = new HashMap<>(8);

    public ExecutorServiceManager() {
        EXECUTOR_MANAGER.put("runnableThread", DefaultThreadPoolExecutorFactory.createRunnableThreadPoolExecutor());
    }

    public ExecutorService getExecutorServiceByName(String name) {
        return EXECUTOR_MANAGER.get(name);
    }
}
