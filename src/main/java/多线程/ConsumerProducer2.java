package 多线程;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 15:48 2020/3/19
 * @Modified By:
 */
public class ConsumerProducer2 {
    private Queue<Integer> queue;
    private static final int MaxCap = 5;
    private Random random = new Random();
    private Lock lock = new ReentrantLock();
    private Condition conditionProduer = lock.newCondition();
    private Condition conditionConsumer = lock.newCondition();

    public ConsumerProducer2(Queue<Integer> queue) {
        this.queue = queue;
    }

    class Producer extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.lock();
                while (queue.size() == MaxCap) {
                    System.out.println("生产者队列已经满了....");
                    try {
                        conditionProduer.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int i = random.nextInt(100);
                queue.add(i);
                System.out.println(Thread.currentThread().getName() + " 生产者生产了 " + i);
                conditionConsumer.signalAll();
                lock.unlock();
            }
        }
    }

    class Consumer extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.lock();
                while (queue.size() == 0) {
                    System.out.println("消费者不能继续消费...");
                    try {
                        conditionConsumer.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int i = queue.poll();
                System.out.println(Thread.currentThread().getName() + " 消费者消费 " + i);
                conditionProduer.signalAll();
                lock.unlock();
            }
        }
    }

    public void fun() {
        Thread producer1 = new Producer();
        Thread consumer1 = new Consumer();
        producer1.start();
        consumer1.start();
    }

    public static void main(String[] args) {
        ConsumerProducer2 consumerProducer2 = new ConsumerProducer2(new LinkedList<>());
        consumerProducer2.fun();
    }
}
