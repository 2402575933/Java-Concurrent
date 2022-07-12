package com.tommy.review_create_thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.Method_2")
public class Method_2 {

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                // 任务代码
                log.debug("logging...");
            }
        };
        Thread t1 = new Thread(r, "t1");
        t1.start();
    }

}
