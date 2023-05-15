package com.leeeryu.thread;

public class Counter {
    private int count = 0;

    public synchronized void increment() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        count++;
        System.out.println("Thread Name: " + Thread.currentThread().getName() + "Count is " + count);
    }

    public int getCount() {
        return count;
    }
}
