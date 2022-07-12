package com.tommy.sleep;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.Method_1")
public class Method_1 {

    private static int count1 = 0;
    private static int count2 = 0;

    public static void main(String[] args) {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    Thread.yield();
                    System.out.println(" ----> t1  " + count1 ++ );
                }
            }
        };
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(" ----> t2  " + count2 ++ );
                }
            }
        };

        Thread t1 = new Thread(r1, "t1");
        Thread t2 = new Thread(r2, "t2");

        t1.start();
        t2.start();
    }
}
