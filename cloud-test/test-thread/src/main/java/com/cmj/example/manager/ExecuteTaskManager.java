package com.cmj.example.manager;

public interface ExecuteTaskManager<T> extends Runnable {

    void addTask(T task);

}
