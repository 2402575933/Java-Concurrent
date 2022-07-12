package com.tommy.sleep;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.Method_1")
public class Method_1 {
    public static void main(String[] args) {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                log.debug("logging... 开始睡眠");
                try {
                    Thread.sleep(1000);  // 睡眠代码写在 线程 t1 中，代表线程 t1 睡眠 1s
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Thread t1 = new Thread(r1, "t1");
        t1.start();
        log.debug("logging");
    }
}
