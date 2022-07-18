package com.tommy.管程.并发问题;


public class Method_1 {

    static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i ++ ) {
                count ++ ;  // 临界区
            }
        }, "t1");
        
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i ++ ) {
                count -- ;  // 临界区
            }
        }, "t2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(count);
    }
}
