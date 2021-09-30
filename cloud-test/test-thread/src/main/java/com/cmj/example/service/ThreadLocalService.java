package com.cmj.example.service;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.RandomUtil;
import com.alibaba.fastjson.JSONObject;
import com.cmj.example.manager.CallbackExecuteTaskManager;
import com.cmj.example.manager.RunnableExecuteTaskManager;
import com.cmj.example.utils.thread.MDCCallbackTask;
import com.cmj.example.utils.thread.MDCExecuteTask;
import com.cmj.example.vo.TaskParamVo;
import com.cmj.example.vo.TaskResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author mengjie_chen
 * @description
 * @date 2021/9/29
 */
@Component
@Slf4j
public class ThreadLocalService {

    @Resource
    private RunnableExecuteTaskManager runnableExecuteTaskManager;
    @Resource
    private CallbackExecuteTaskManager callbackExecuteTaskManager;

    public void addTask() {
        TaskParamVo paramVo = TaskParamVo.builder().id(UUID.fastUUID().toString(true)).build();
        log.info("add task is -----> {}", JSONObject.toJSONString(paramVo));
        runnableExecuteTaskManager.addTask(new MDCExecuteTask<TaskParamVo>(paramVo) {
            @Override
            protected void doExecute() {
                log.info("param is -----> {}", getParam().getId());
            }
        });

    }

    public void addCallbackTask() {
        TaskParamVo paramVo = TaskParamVo.builder().id(UUID.fastUUID().toString(true)).build();
        log.info("add task is -----> {}", JSONObject.toJSONString(paramVo));
        callbackExecuteTaskManager.addTask(new MDCCallbackTask<TaskParamVo, TaskResultVo>(paramVo) {
            @Override
            protected void onError(Throwable t) {
                log.error("onError exception is -----> {}", t.toString());
            }

            @Override
            protected void onBack(TaskResultVo result) {
                log.info("onBack result is -----> {}", JSONObject.toJSONString(result));
            }

            @Override
            protected TaskResultVo doExecute() {
                int code = RandomUtil.randomInt(100);
                TaskResultVo resultVo = TaskResultVo.builder().code(code).msg(getParam().getId()).build();
                log.info("doExecute result is -----> {}", JSONObject.toJSONString(resultVo));
                if (code % 10 == 0) {
                    throw new RuntimeException("对10取余等于0，抛出异常：" + code);
                }
                return resultVo;
            }
        });
    }
}
