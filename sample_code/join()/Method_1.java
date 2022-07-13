package com.tommy.join;

import lombok.extern.slf4j.Slf4j;

/**
 join 的简单实例，以赋值的形式演示 join 的效果，最终的结果 count = 1
 如果在主线程中不进行 t1 线程的等待，则 主线程优先执行完，count 由于 t1 线程仍在阻塞，导致 count 赋值失败，仍为初始值 0，打印结果也是 0
*/
@Slf4j(topic = "c.Method_1")
public class Method_1 {

    public static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                try {
                    log.debug("开始睡眠");
                    Thread.sleep(1000);
                    count = 1;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                log.debug("logging...");
            }
        };
        Thread t1 = new Thread(r1, "t1");
        t1.start();
        t1.join();  // 无 join，打印输出count = 0, 有 join，打印输出 count = 1
        log.debug("开始, count = {}", count);
    }
}
