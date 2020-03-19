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
    private CyclicBarrier cyclicBarrier1 = new CyclicBarrier(0);
    private CyclicBarrier cyclicBarrier2 = new CyclicBarrier(1);
    private CyclicBarrier cyclicBarrier3 = new CyclicBarrier(1);

    private int countNum = 0;

}
