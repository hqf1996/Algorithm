package 多线程;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: hqf
 * @description: 基于CountDownLatch实现
 * @Data: Create in 13:10 2020/3/19
 * @Modified By:
 */
public class PrintABC3 {
    private CountDownLatch countDownLatch1 = new CountDownLatch(0);
    private CountDownLatch countDownLatch2 = new CountDownLatch(1);
    private CountDownLatch countDownLatch3 = new CountDownLatch(1);

    private int countNum = 0;

    class PrintA extends Thread {

        @Override
        public void run() {
            for (int i = 0 ; i < 10 ; ++i) {
                while (countNum % 3 != 0) {
                        try {
                        countDownLatch1.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " A");
                countNum++;
                countDownLatch2.countDown();
                countDownLatch1 = new CountDownLatch(1);
            }
        }
    }

    class PrintB extends Thread {

        @Override
        public void run() {
            for (int i = 0 ; i < 10 ; ++i) {
                while (countNum % 3 != 1) {
                    try {
                        countDownLatch2.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " B");
                countNum++;
                countDownLatch3.countDown();
                countDownLatch2 = new CountDownLatch(1);
            }
        }
    }

    class PrintC extends Thread {

        @Override
        public void run() {
            for (int i = 0 ; i < 10 ; ++i) {
                while (countNum % 3 != 2) {
                    try {
                        countDownLatch3.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " C");
                countNum++;
                countDownLatch1.countDown();
                countDownLatch3 = new CountDownLatch(1);
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
        PrintABC3 printABC3 = new PrintABC3();
        printABC3.fun();
    }
}
