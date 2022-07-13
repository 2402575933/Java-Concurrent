package com.tommy.interrupt;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.Method_2")
public class Method_2 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() ->{
            while (true) {
                boolean isInterrupted = Thread.currentThread().isInterrupted();
                if (isInterrupted) {
                    log.debug("interrupted...");
                    break;
                }
            }
        }, "t1");
        t1.start();
        Thread.sleep(1000);
        t1.interrupt();
        log.debug("t1 的 打断标记: {}", t1.isInterrupted());
    }
}
