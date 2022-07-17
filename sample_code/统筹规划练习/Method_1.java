package com.tommy.统筹问题;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j(topic = "c.Method_1")
public class Method_1 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            try {
                log.debug("洗水壶");
                TimeUnit.MINUTES.sleep(1);
                log.debug("烧开水");
                TimeUnit.MINUTES.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "老王");

        Thread t2 = new Thread(() -> {
            try {
                log.debug("洗茶壶，洗茶杯，拿茶叶");
                TimeUnit.MINUTES.sleep(4);
                t1.wait();
                log.debug("开始泡茶");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "小王");

        t1.start();
        t2.start();
    }
}
