package com.cmj.example.utils.thread;

public interface CallbackTask<R> {

    R execute();

    void onSuccess(R result);

    void onFailure(Throwable t);

}
