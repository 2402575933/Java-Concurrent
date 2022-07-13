// 多线程的 join 实例
package com.tommy;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
创建两个线程 t1、t2，二者同时开始执行，分析 主线程共等待多少时间？
对调 在主线程中对 t1, t2 线程的 join 顺序，主线程共等待多少时间？
 */

@Slf4j(topic = "c.Test09")
public class Test09 {

    public static int count_1 = 0;
    public static int count_2 = 0;

    public static void main(String[] args) throws InterruptedException {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    count_1 = 10;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    count_2 = 10;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t1 = new Thread(r1, "t1");
        Thread t2 = new Thread(r2, "t2");

        t1.start();
        t2.start();

        long start = System.currentTimeMillis();

        t1.join();
        t2.join();

        long end = System.currentTimeMillis();
        log.debug("{}", end - start);
    }
}
