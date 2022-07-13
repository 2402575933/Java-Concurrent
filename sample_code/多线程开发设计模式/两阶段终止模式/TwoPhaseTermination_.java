package com.tommy.interrupt;

import lombok.extern.slf4j.Slf4j;

/**
模拟了 一个服务器利用一个线程收集日志，使用 两阶段终止模式 优雅的终止此线程
 */

@Slf4j(topic = "c.TwoPhaseTermination")
public class TwoPhaseTermination {
    public static void main(String[] args) throws InterruptedException {
        TwoPhaseTermination_ tpt = new TwoPhaseTermination_();
        tpt.start();
        Thread.sleep(3500);
        tpt.stop();
    }
}

@Slf4j(topic = "c.TwoPhaseTermination_")
class TwoPhaseTermination_ {

    public Thread thread;

    // 开始线程
    public void start() {
        // 假设这是一个收集服务器日志的程序
        thread = new Thread(() -> {
            while (true) {
                Thread current = Thread.currentThread();
                if (current.isInterrupted()) {
                    // 被打断，执行后事
                    log.debug("被打断...");
                    break;
                }
                try {
                    Thread.sleep(1000);
                    log.debug("正在收集日志...");
                } catch (InterruptedException e) {
                    // 抛出异常代表 线程在 睡眠期间被打断
                    e.printStackTrace();
                    current.interrupt(); // 一定要在此处设置上 被打断标签，因为在 线程阻塞期间的打断线程，被打断标签仍被重置为false
                }
            }
        });
        thread.start();
    }

    // 两阶段终止模式优雅的停止 thread 线程
    public void stop() {
        thread.interrupt();
    }
}
