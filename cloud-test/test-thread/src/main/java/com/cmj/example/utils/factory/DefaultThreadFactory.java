package com.cmj.example.utils.factory;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author mengjie_chen
 * @description
 * @date 2021/9/30
 */
public class DefaultThreadFactory implements ThreadFactory {

    private final String prefix;
    private final AtomicInteger countor = new AtomicInteger();


    public DefaultThreadFactory(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r, getThreadName());
    }

    private String getThreadName() {
        return prefix + "-" + "Pool-" + countor.incrementAndGet();
    }

    public static ThreadFactory createDefaultThreadFactory(String prefix) {
        return new DefaultThreadFactory(prefix);
    }
}
