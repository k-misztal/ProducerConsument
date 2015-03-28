package com.misztal.producerconsument;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by misztal on 28.03.15.
 */
public class Runner {
    private static final int QUEUE_CAPACITY = 10;

    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(QUEUE_CAPACITY);

        Producer producer = new Producer(blockingQueue, "Producer 1");
        Consumer consumer = new Consumer(blockingQueue, "Consumer 1");

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
