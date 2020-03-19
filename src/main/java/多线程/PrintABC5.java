package 多线程;

import java.util.concurrent.Semaphore;

/**
 * @Author: hqf
 * @description: 基于Semaphore
 * @Data: Create in 14:38 2020/3/19
 * @Modified By:
 */
public class PrintABC5 {
    private Semaphore semaphoreA = new Semaphore(1);
    private Semaphore semaphoreB = new Semaphore(0);
    private Semaphore semaphoreC = new Semaphore(0);

    private int countNum = 0;

    class PrintA extends Thread {
        @Override
        public void run() {
            for (int i = 0 ; i < 10 ; ++i) {
                try {
                    semaphoreA.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " A");
                semaphoreB.release();
            }
        }
    }

    class PrintB extends Thread {
        @Override
        public void run() {
            for (int i = 0 ; i < 10 ; ++i) {
                try {
                    semaphoreB.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " B");
                semaphoreC.release();
            }
        }
    }

    class PrintC extends Thread {
        @Override
        public void run() {
            for (int i = 0 ; i < 10 ; ++i) {
                try {
                    semaphoreC.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " C");
                semaphoreA.release();
            }
        }
    }

    public void fun() {
        Thread t1 = new PrintA();
        Thread t2 = new PrintB();
        Thread t3 = new PrintC();
        t1.start();
        t2.start();
        t3.start();
    }

    public static void main(String[] args) {
        PrintABC5 p = new PrintABC5();
        p.fun();
    }
}
