package com.tommy.守护线程;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.Method_1")
public class Method_1 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    break;
                }
            }
        }, "t1");
        t1.setDaemon(true);  // 设置为 true，默认为 非守护线程
        t1.start();
        
        log.debug("main结束啦");
    }
}
