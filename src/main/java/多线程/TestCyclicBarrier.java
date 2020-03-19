package 多线程;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 15:03 2020/3/19
 * @Modified By:
 */


public class TestCyclicBarrier {
    class PrintT extends Thread {

        private CyclicBarrier cyclicBarrier;

        public PrintT(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println("到达" + Thread.currentThread().getName());
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("开始" + Thread.currentThread().getName());
        }
    }

    public void fun() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

        Thread t1 = new PrintT(cyclicBarrier);
        Thread t2 = new PrintT(cyclicBarrier);
        Thread t3 = new PrintT(cyclicBarrier);
        t1.start();
        t2.start();
        t3.start();
    }

    public static void main(String[] args) {
        TestCyclicBarrier tt = new TestCyclicBarrier();
        tt.fun();
    }
}
