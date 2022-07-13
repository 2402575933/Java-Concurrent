package com.tommy.setPriority;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.Method_1")
public class Method_1 {

    public static int count_1 = 0;
    public static int count_2 = 0;

    public static void main(String[] args) {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("-----> t1 " + count_1 ++ );
                }
            }
        };
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("-----> t2 " + count_2 ++ );
                }
            }
        };

        Thread t1 = new Thread(r1, "t1");
        Thread t2 = new Thread(r2, "t2");

        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();
    }
}
