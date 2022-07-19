// 将 synchronized 加在方法上

public class Method_1 {
    public static void main(String[] args) {

    }
}

class Main {
    private int count = 0;

    public synchronized void a() {

    }
    /**
     * 等价于
     * public void a() {
     *         synchronized (this) {
     *
     *         }
     *     }
     */

    public static synchronized void b() {

    }
    /**
     * 等价于
     * public void b() {
     *     synchronized (Main.class) {
     *
     *     }
     * }
     */
}
