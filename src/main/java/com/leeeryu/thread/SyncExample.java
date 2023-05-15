package com.leeeryu.thread;

public class SyncExample {
    private static final int NUM_THREADS = 10;
    private static final int MAX_COUNT = 100_000;

    public static void main(String[] args) throws InterruptedException {
        final Counter counter = new Counter();

        Thread[] threads = new Thread[NUM_THREADS];
        for (int i = 0; i < NUM_THREADS; ++i) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < MAX_COUNT; ++j) {
                    counter.increment();
                }
            });

            threads[i].start();
        }
//        스레드를 생성하고 시작하면, 각각의 스레드는 비동기적으로 작업을 수행하게 됩니다. 따라서 모든 스레드가 종료되기 전에 main()
//        메소드가 종료되면, 스레드가 아직 작업을 완료하지 못한 상태에서 프로그램이 종료되어 버릴 수 있습니다
//        따라서 Thread.join() 메소드를 사용하여 각 스레드가 종료될 때까지 대기하도록 코드를 작성하는 것이 좋습니다.
//        Thread.join() 메소드는 해당 스레드가 종료될 때까지 대기하는 기능을 수행합니다.
//        위 예제에서는 10개의 스레드가 생성되었으므로, Thread.join() 메소드를 10번 호출하여
//        각각의 스레드가 종료될 때까지 대기하도록 구현되어 있습니다.
//
//        따라서 main() 메소드에서는 모든 스레드가 종료된 이후에 최종적인 출력을 수행하게 됩니다.
//        이렇게 함으로써, 스레드가 모두 종료될 때까지 대기하지 않아도 프로그램이 올바르게 작동할 수 있도록 보장할 수 있습니다.
        for (int i = 0; i < NUM_THREADS; ++i) {
            threads[i].join();
        }

        System.out.println(Thread.currentThread());
        System.out.println("Final count: " + counter.getCount());
    }

    private static class Counter {
        private int count = 0;

        public synchronized void increment() {
            count++;
        }

        public synchronized int getCount() {
            return count;
        }
    }
}
