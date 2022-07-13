package com.tommy.interrupt;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
打断阻塞线程，立即停止，抛出异常，打断标记被重置为false
 */

@Slf4j(topic = "c.Method_1")
public class Method_1 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                log.debug("sleep...");
                TimeUnit.SECONDS.sleep(5); // 线程 t1 执行后，睡眠 5s
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "t1");

        t1.start(); // 开启t1线程
        TimeUnit.SECONDS.sleep(1);
        log.debug("interrupt...");
        t1.interrupt();
        log.debug("打断标记：{}", t1.isInterrupted());
    }
}
