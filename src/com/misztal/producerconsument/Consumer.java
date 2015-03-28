package com.misztal.producerconsument;

import java.util.concurrent.BlockingQueue;

/**
 * Created by misztal on 28.03.15.
 */
public class Consumer implements Runnable {
    private BlockingQueue<Integer> blockingQueue;
    private String name = "Consumer";

    public Consumer(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public Consumer(BlockingQueue<Integer> blockingQueue, String name) {
        this.blockingQueue = blockingQueue;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println(name + ": attempting to take object from queue...");
                int val = blockingQueue.take();
                consume(val);
                System.out.println(name + ": value [" + val + "] has been taken and consumed");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void consume(Integer object) {
        // TODO if necessary do stg with consumed object
    }
}
