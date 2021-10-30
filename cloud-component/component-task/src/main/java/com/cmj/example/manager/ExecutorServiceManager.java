package com.cmj.example.manager;

import com.cmj.example.factory.DefaultThreadPoolExecutorFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.stream.Collectors;

/**
 * @author mengjie_chen
 * @description
 * @date 2021/9/30
 */
@Component
public class ExecutorServiceManager {
    public static final String RUNNABLE = "runnableThread";
    public static final String CALLBACK = "callbackThread";

    private static final Map<String, ExecutorService> EXECUTOR_MANAGER = new HashMap<>(8);

    public ExecutorServiceManager() {
        EXECUTOR_MANAGER.put("runnableThread", DefaultThreadPoolExecutorFactory.createRunnableThreadPoolExecutor());
        EXECUTOR_MANAGER.put("callbackThread", DefaultThreadPoolExecutorFactory.createCallbackThreadPoolExecutor());
    }

    @SuppressWarnings("unchecked")
    public <T extends ExecutorService> T getExecutorServiceByName(String name) {
        return (T) EXECUTOR_MANAGER.get(name);
    }

    public List<ExecutorService> getExecutorServices() {
        return new ArrayList<>(EXECUTOR_MANAGER.values());
    }
}
