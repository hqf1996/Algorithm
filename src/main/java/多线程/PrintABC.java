package 多线程;

/**
 * @Author: hqf
 * @description: 三个线程循环打印ABC，基于Synchronized、wait、notifyAll
 * @Data: Create in 9:28 2020/3/19
 * @Modified By:
 */
class PrintThread implements Runnable {
    // 共享锁
    private static Object lock = new Object();
    // 当前的打印次数
    private static int currentCount = 0;

    private int flag;
    private String value;

    public PrintThread(int flag, String value) {
        this.flag = flag;
        this.value = value;
    }

    @Override
    public void run() {
        for (int i = 0 ; i < 10 ; ++i) {
            synchronized (lock) {
                // 0, 1, 2
                while (currentCount % 3 != flag) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " " + value);
                currentCount++;
                // 通知其他线程打印
                lock.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        PrintThread printThread1 = new PrintThread(0, "A");
        PrintThread printThread2 = new PrintThread(1, "B");
        PrintThread printThread3 = new PrintThread(2, "C");
        Thread t1 = new Thread(printThread1);
        Thread t2 = new Thread(printThread2);
        Thread t3 = new Thread(printThread3);
        t1.start();
        t2.start();
        t3.start();
    }
}
