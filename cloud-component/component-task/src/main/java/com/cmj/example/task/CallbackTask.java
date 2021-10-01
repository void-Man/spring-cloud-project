package com.cmj.example.task;

public interface CallbackTask<R> {

    R execute();

    void onSuccess(R result);

    void onFailure(Throwable t);

}
