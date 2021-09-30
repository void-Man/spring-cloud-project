package com.cmj.example.service;

import cn.hutool.core.lang.UUID;
import com.alibaba.fastjson.JSONObject;
import com.cmj.example.manager.ExecuteTaskManager;
import com.cmj.example.utils.thread.MDCExecuteTask;
import com.cmj.example.vo.TaskParamVo;
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
    private ExecuteTaskManager executeTaskManager;

    public void addTask() {
        TaskParamVo paramVo = TaskParamVo.builder().id(UUID.fastUUID().toString(true)).build();
        log.info("add task is -----> {}", JSONObject.toJSONString(paramVo));
        executeTaskManager.add(new MDCExecuteTask<TaskParamVo>(paramVo) {
            @Override
            protected void doExecute() {
                log.info("param is -----> {}", getParam().getId());
            }
        });

    }
}
