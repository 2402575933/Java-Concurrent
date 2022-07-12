package com.tommy.review_create_thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

@Slf4j(topic = "c.Method_3")
public class Method_3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                log.debug("logging...");
                return 100;
            }
        });
        Thread t = new Thread(futureTask, "t1");

        Integer a = futureTask.get();
        System.out.println(a);
    }
}
