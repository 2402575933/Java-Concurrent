package com.tommy;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

@Slf4j(topic = "c.Test10")
public class Test10 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            log.debug("logging...");
            LockSupport.park(); // 进入park
            log.debug("interrupted...");
            System.out.println("当前线程的中断状态：" + Thread.interrupted());  // true  会自动清除 中断标记
//            System.out.println("当前线程的中断状态：" + Thread.currentThread().isInterrupted()); // false
            log.debug("parking...");
            LockSupport.park();
        }, "t1");
        t1.start();
        Thread.sleep(1000);
        t1.interrupt();
    }
}
