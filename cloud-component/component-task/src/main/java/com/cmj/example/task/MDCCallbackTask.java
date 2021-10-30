package com.cmj.example.task;


import cn.hutool.core.lang.Snowflake;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

import java.util.Map;

/**
 * @author mengjie_chen
 * @description
 * @date 2021/10/1
 */
@Slf4j
public abstract class MDCCallbackTask<P, R> implements CallbackTask<R> {
    private static final int DEFAULT_RETRY_COUNT = 3;

    @Getter
    private final int retryCount;
    @Getter
    private final P param;
    private final long taskId;
    private final Map<String, String> mainMdcMap;

    public MDCCallbackTask(int retryCount, P param) {
        this.retryCount = retryCount;
        this.param = param;
        this.taskId = new Snowflake().nextId();
        this.mainMdcMap = MDC.getCopyOfContextMap();
    }

    public MDCCallbackTask(P param) {
        this(DEFAULT_RETRY_COUNT, param);
    }

    @Override
    public R execute() {
        setMDCContext();
        try {
            return doExecute();
        } catch (Exception e) {
            throw e;
        } finally {
            MDC.clear();
        }
    }

    @Override
    public void onSuccess(R result) {
        setMDCContext();
        try {
            onBack(result);
        } catch (Exception e) {
            log.error("回调异步任务出现异常 -----> {}", e.toString());
            throw e;
        } finally {
            MDC.clear();
        }
    }


    @Override
    public void onFailure(Throwable t) {
        setMDCContext();
        try {
            onError(t);
        } catch (Exception e) {
            log.error("处理异常时出现异常 -----> {}", e.toString());
            throw e;
        } finally {
            MDC.clear();
        }
    }

    protected abstract void onError(Throwable t);

    protected abstract void onBack(R result);

    protected abstract R doExecute();

    private void setMDCContext() {
        // 将父线程的MDC内容传给子线程
        MDC.setContextMap(mainMdcMap);
    }
}
