package com.leeeryu.thread;

import java.util.ArrayList;
import java.util.List;

public class MyRunnable implements Runnable {
    private String name;
    public MyRunnable(String name) {
        this.name = name;
    }
    @Override
    public void run() {
        System.out.println("Thread " + this.name + " is running");
    }
}

class MyClass {
    private List<Thread> threads = new ArrayList<>();
    public MyClass(Runnable runnable) {
        this.threads.add(new Thread(runnable));
    }

    public void startThread() throws InterruptedException {
        for (Thread thread : this.threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
    }
}
class MyRunnableTest {
    public static void main(String[] args) throws InterruptedException {
        MyRunnable runnable1 = new MyRunnable("Runnable1");
        MyRunnable runnable2 = new MyRunnable("Runnable2");
        // 다른 클래스에서 Runnable 인터페이스를 구현한 클래스의 인스턴스를 생성하고 스레드로 실행하는 예제

        Thread t1 = new Thread(runnable1);
        Thread t2 = new Thread(runnable2);

        Thread t3 = new Thread(() -> {
            System.out.println("Thread t3 is running");
        });
        // 쓰레드간의 우선순위를 설정
        t1.setPriority(3);
        t1.start();
        t3.setPriority(1);
        t3.start();
        t2.setPriority(2);
        t2.start();
        // t1 -> t2 -> t3
        // t3 -> t2 -> t1
    }
}
