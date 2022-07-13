package com.tommy.interrupt;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;

@Slf4j(topic = "c.InterruptPark")
public class InterruptPark {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            log.debug("park...");
            LockSupport.park(); // 进入Park 状态
            log.debug("interrupt...unpark...");
            log.debug("打断状态{}", Thread.currentThread().isInterrupted());  // true
            // 尝试 再次进入 Park 状态
            LockSupport.park();
            log.debug("unpark again..."); // 标记为 true，再次被打断，无法进入 park
        }, "t1");
    }
}
