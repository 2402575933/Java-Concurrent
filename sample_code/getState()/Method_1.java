package com.tommy;

import lombok.extern.slf4j.Slf4j;

/**
以 sleep 后的状态为例
 */

@Slf4j(topic = "c.Test10")
public class Test10 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() ->{
            log.debug("logging...");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");
        t1.start();
        Thread.sleep(500);

        log.debug("t1 的状态：{}", t1.getState());  //TIMED_WAITING
    }
}
