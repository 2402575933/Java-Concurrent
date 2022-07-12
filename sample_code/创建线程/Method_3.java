package com.tommy.review_create_thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.Method_2")
public class Method_2 {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            log.debug("logging...");
        }, "t1");
        t1.start();
    }

}
