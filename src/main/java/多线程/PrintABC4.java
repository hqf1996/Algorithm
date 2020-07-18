package 多线程;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author: hqf
 * @description: 基于CyclicBarrier实现
 * @Data: Create in 13:50 2020/3/19
 * @Modified By:
 */
public class PrintABC4 {
    private CyclicBarrier cyclicBarrier1 = new CyclicBarrier(1);
    private CyclicBarrier cyclicBarrier2 = new CyclicBarrier(1);
    private CyclicBarrier cyclicBarrier3 = new CyclicBarrier(1);

    private int countNum = 0;

    class ThreadA extends Thread {
        @Override
        public void run() {
            for (int i = 0 ; i < 10 ; ++i) {
                while (countNum % 3 != 0) {
                    cyclicBarrier1.reset();
                }
                System.out.println(Thread.currentThread().getName() + " A");
                try {
                    cyclicBarrier2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                countNum++;
            }
        }
    }

    class ThreadB extends Thread {
        @Override
        public void run() {
            for (int i = 0 ; i < 10 ; ++i) {
                while (countNum % 3 != 1) {
                    cyclicBarrier2.reset();
                }
                System.out.println(Thread.currentThread().getName() + " B");
                try {
                    cyclicBarrier3.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                countNum++;
            }
        }
    }

    class ThreadC extends Thread {
        @Override
        public void run() {
            for (int i = 0 ; i < 10 ; ++i) {
                while (countNum % 3 != 2) {
                    cyclicBarrier3.reset();
                }
                System.out.println(Thread.currentThread().getName() + " C");
                try {
                    cyclicBarrier1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                countNum++;
            }
        }
    }

    public void fun() {
        Thread thread1 = new ThreadA();
        Thread thread2 = new ThreadB();
        Thread thread3 = new ThreadC();

        thread1.start();
        thread2.start();
        thread3.start();


    }

    public static void main(String[] args) {
        PrintABC4 printABC4 = new PrintABC4();
        printABC4.fun();
    }
}
