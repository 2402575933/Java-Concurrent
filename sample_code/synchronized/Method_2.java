// synchronized 面向对象的优化写法
// 共享变量的保护由对象内部实现线程安全的业务逻辑即可，仅对外暴露线程安全的方法即可。

public class Method_1 {
    public static void main(String[] args) throws InterruptedException {
        Room room = new Room();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i ++ ) {
                room.decrement();
            }
        }, "t1");
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i ++ ) {
                room.increment();
            }
        }, "t2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(room.getCount());
    }
}

class Room {
    private int count = 0;

    public void increment() {
        synchronized (this) {
            this.count ++ ;
        }
    }

    public void decrement() {
        synchronized (this) {
            this.count -- ;
        }
    }

    public int getCount() {
        return this.count;
    }
}
