package 多线程;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: hqf
 * @description: 基于ReentrantLock、await、signal实现
 * @Data: Create in 11:22 2020/3/19
 * @Modified By:
 */
public class PrintABC2 {
    private Lock lock = new ReentrantLock();
    private int currentCount = 0;
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    private Condition conditionC = lock.newCondition();

    class PrintThread2_A extends Thread {
        @Override
        public void run() {
            for (int i = 0 ; i < 10 ; ++i) {
                lock.lock();
                while (currentCount % 3 != 0) {
                    try {
                        conditionA.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + "--->A");
                currentCount++;
                conditionB.signal();
                lock.unlock();
            }
        }
    }

    class PrintThread2_B extends Thread {
        @Override
        public void run() {
            for (int i = 0 ; i < 10 ; ++i) {
                lock.lock();
                while (currentCount % 3 != 1) {
                    try {
                        conditionB.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + "--->B");
                currentCount++;
                conditionC.signal();
                lock.unlock();
            }
        }
    }

    class PrintThread2_C extends Thread {
        @Override
        public void run() {
            for (int i = 0 ; i < 10 ; ++i) {
                lock.lock();
                while (currentCount % 3 != 2) {
                    try {
                        conditionC.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + "--->C");
                currentCount++;
                conditionA.signal();
                lock.unlock();
            }
        }
    }

    public void fun() {
        Thread t1 = new PrintThread2_A();
        Thread t2 = new PrintThread2_B();
        Thread t3 = new PrintThread2_C();

        t1.start();
        t2.start();
        t3.start();
    }

    public static void main(String[] args) {
        PrintABC2 printABC2 = new PrintABC2();
        printABC2.fun();
    }
}
