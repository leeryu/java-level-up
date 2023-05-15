package com.leeeryu.thread;

public class CountingThread extends Thread {
    private volatile boolean stopFlag = false;

    public void run() {
        int count = 0;
        while (!stopFlag) {
            System.out.println("Count: " + count);
            count++;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Thread stopped.");
    }

    public void stopThread() {
        stopFlag = true;
    }
}

class CountingThreadMain {
    public static void main(String[] args) {
        CountingThread thread = new CountingThread();
        thread.start();

        // 일정 시간 후 스레드 종료
        try {
            Thread.sleep(5000);
            thread.stopThread();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


