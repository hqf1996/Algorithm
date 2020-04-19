package 多线程;

/**
 * @Author: hqf
 * @description: 手写一个死锁
 * @Data: Create in 16:57 2020/3/20
 * @Modified By:
 */
class myDeadLock extends Thread {
    private static Object object1 = new Object();
    private static Object object2 = new Object();
    boolean flag;

    public myDeadLock(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag) {
            synchronized (object1) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object2) {
                    System.out.println("锁住object2");
                }
            }
        } else {
            synchronized (object2) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object1) {
                    System.out.println("锁住object1");
                }
            }
        }
    }
}

public class DeadLock {
    public static void main(String[] args) {
        Thread t1 = new myDeadLock(true);
        Thread t2 = new myDeadLock(false);
        t1.start();
        t2.start();
    }
}
