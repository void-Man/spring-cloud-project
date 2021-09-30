package com.cmj.example.utils.factory;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author mengjie_chen
 * @description
 * @date 2021/9/30
 */
public class DefaultBlockQueueFactory {

    public static final int DEFAULT_MAX_QUEUE_LENGTH = Integer.MAX_VALUE;

    public static <T> BlockingDeque<T> creaLinkedBlockQueue(int capacity) {
        if (capacity <= 0) {
            capacity = Integer.MAX_VALUE;
        }
        return new LinkedBlockingDeque<>(capacity);
    }

    public static <T> BlockingDeque<T> creaLinkedBlockQueue() {
        return creaLinkedBlockQueue(DEFAULT_MAX_QUEUE_LENGTH);
    }
}
