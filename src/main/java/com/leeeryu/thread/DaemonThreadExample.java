package com.leeeryu.thread;

public class DaemonThreadExample extends Thread {

    @Override
    public void run() {
        while (true) {
            System.out.println("DaemonThreadExample run");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class DaemonThreadExampleMain {
    public static void main(String[] args) {
        DaemonThreadExample daemonThreadExample = new DaemonThreadExample();
        daemonThreadExample.setDaemon(true);
        daemonThreadExample.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
