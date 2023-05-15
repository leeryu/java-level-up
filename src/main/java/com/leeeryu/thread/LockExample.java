package com.leeeryu.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Thread mainThread = Thread.currentThread();

//        락(lock)은 스레드 간의 공유 자원에 대한 접근을 제어하는 동기화 메커니즘입니다. Java에서는 synchronized 키워드를
//        이용하여 락을 구현할 수 있습니다. synchronized 키워드는 하나의 스레드만 락을 획득할 수 있으므로
//        다른 스레드는 락이 해제될 때까지 대기합니다.
//        이를 통해 멀티 스레드 환경에서의 상호배제(mutual exclusion)를 구현할 수 있습니다.
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                lock.lock();
                try {
                    System.out.println("Thread ID: " + Thread.currentThread().getId() +
                            ", Method: " + Thread.currentThread().getStackTrace()[1].getMethodName() +
                            ", Time: " + System.currentTimeMillis());
                    if (mainThread.isAlive()) {
                        System.out.println("Main Thread Alive!!");
                        System.out.println("Main Thread ID: " + mainThread.getId() +
                                ", State: " + mainThread.getState());
                    }
                } finally {
                    lock.unlock();
                }
            }).start();
        }
    }
}
