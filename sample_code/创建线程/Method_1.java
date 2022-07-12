package com.tommy.review_create_thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.Method_1")
public class Method_1 {
    public static void main(String[] args) {
        Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                // 新线程的任务代码
                log.debug("logging...");
            }
        };
//        t1.setName("t1");
        t1.start(); // 启动新线程
    }
}
