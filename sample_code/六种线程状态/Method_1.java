package com.tommy.六种线程状态;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.Method_1")
public class Method_1 {
    public static void main(String[] args) throws InterruptedException {
        /**
         * NEW
         * RUNNABLE
         * BLOCKED
         * WAITING
         * TIMED_WAITING
         * TERMINATED
         */

        // NEW
        Thread t1 = new Thread(() -> {
            log.debug("logging...");
        }, "t1");

        // RUNNABLE
        Thread t2 = new Thread(() -> {
            for (;;) {
            }
        }, "t2");
        t2.start();

        // BLOCKED
        Thread t3 = new Thread(() -> {
            synchronized (Method_1.class) {
                try {
                    Thread.sleep(10000000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t3.start();

        // WAITING
        Thread t4 = new Thread(() -> {
            try {
                t2.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t4");
        t4.start();

        // TIMED_WAITING
        Thread t5 = new Thread(() -> {
            try {
                Thread.sleep(500000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t5");
        t5.start();

        // TERMINATED
        Thread t6 = new Thread(() -> {
        }, "t6");

        Thread t7 = new Thread(() -> {
            synchronized (Method_1.class) {
                try {
                    Thread.sleep(10000000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t7.start();

        t6.start();
        Thread.sleep(1000);

        log.debug("{}", t1.getState());   // NEW
        log.debug("{}", t2.getState());   // RUNNABLE
        log.debug("{}", t4.getState());   // TERMINATED
        log.debug("{}", t5.getState());   // TIMED_WAITING
        log.debug("{}", t6.getState());   // TERMINATED
        log.debug("{}", t7.getState());   // BLOCKED


    }
}
