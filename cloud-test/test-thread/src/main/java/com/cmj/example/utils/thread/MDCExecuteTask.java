package com.cmj.example.utils.thread;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

import java.util.Map;

/**
 * @author mengjie_chen
 * @description
 * @date 2021/9/30
 */
@Slf4j
public abstract class MDCExecuteTask<T> implements ExecuteTask {
    private static final int DEFAULT_RETRY_COUNT = 3;

    @Getter
    private final int retryCount;
    @Getter
    private final T param;
    private final Map<String, String> mainMdcMap;

    public MDCExecuteTask(int retryCount, T param) {
        this.retryCount = retryCount;
        this.param = param;
        this.mainMdcMap = MDC.getCopyOfContextMap();
    }

    public MDCExecuteTask(T param) {
        this(DEFAULT_RETRY_COUNT, param);
    }

    @Override
    public void execute() {
        setMDCContext();
        try {
            doExecute();
        } catch (Exception e) {
            log.error("执行异步任务出现异常 -----> {}", e.toString());
        } finally {
            MDC.clear();
        }
    }

    protected abstract void doExecute();

    private void setMDCContext() {
        // 将父线程的MDC内容传给子线程
        MDC.setContextMap(mainMdcMap);
    }
}
