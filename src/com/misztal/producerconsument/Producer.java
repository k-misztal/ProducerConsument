package com.misztal.producerconsument;

import java.util.concurrent.BlockingQueue;

/**
 * Created by misztal on 28.03.15.
 */
public class Producer implements Runnable {
    private BlockingQueue<Integer> blockingQueue;

    public Producer(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                blockingQueue.put(produce());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    Integer produce() {
        return 1;
    }
}
