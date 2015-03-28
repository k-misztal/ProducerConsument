package com.misztal.producerconsument;

import java.util.concurrent.BlockingQueue;

/**
 * Created by misztal on 28.03.15.
 */
public class Producer implements Runnable {
    private BlockingQueue<Integer> blockingQueue;
    private String name = "Producer";

    public Producer(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public Producer(BlockingQueue<Integer> blockingQueue, String name) {
        this.blockingQueue = blockingQueue;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int val = produce();
                blockingQueue.put(val);
                System.out.println(name + ": value [" + val + "] inserted into queue");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    Integer produce() {
        int val = 1;
        System.out.println(name + ": produced value [" + val + "], attempting to put into queue...");
        return val;
    }
}
