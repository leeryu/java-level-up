package com.leeeryu.thread;

public class ThreadLocalExample {

    public static void main(String[] args) {
        ThreadLocal<Integer> counter = new ThreadLocal<>();
        counter.set(0);

        Thread thread1 = new Thread(() -> {
            counter.set(counter.get() + 1);
            System.out.println("Counter value in thread 1: " + counter.get());
        });

        Thread thread2 = new Thread(() -> {
//            counter.set(counter.get() + 1);
//            System.out.println("Counter value in thread 2: " + counter.get());
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
