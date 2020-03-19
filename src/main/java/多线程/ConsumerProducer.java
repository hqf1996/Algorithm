package 多线程;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * @Author: hqf
 * @description: 生产者消费者问题，用Synchronized + wait + notifyAll
 * @Data: Create in 15:18 2020/3/19
 * @Modified By:
 */
public class ConsumerProducer {
    private Queue<Integer> queue;
    private Random random = new Random();
    private static final int MaxCap = 5;

    public ConsumerProducer(Queue<Integer> queue) {
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
                synchronized (queue) {
                    while (queue.size() == MaxCap) {
                        try {
                            System.out.println(Thread.currentThread().getName() + " 队列已满，等待消费者消耗...");
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    int i = random.nextInt(100);
                    System.out.println(Thread.currentThread().getName() + " 生产者生产出" + i);
                    queue.add(i);
                    queue.notifyAll();
                }
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
                synchronized (queue) {
                    while (queue.size() == 0) {
                        System.out.println(Thread.currentThread().getName() + " 队列为空，消费者不能消费");
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    int i = queue.poll();
                    System.out.println(Thread.currentThread().getName() + " 消费者消费" + i);
                    queue.notifyAll();
                }
            }
        }
    }

    public void fun() {
        Thread producer1 = new Producer();
        Thread producer2 = new Producer();
        Thread consumer1 = new Consumer();
        Thread consumer2 = new Consumer();
        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();
    }

    public static void main(String[] args) {
        Queue queue = new LinkedList();
        ConsumerProducer consumerProducer = new ConsumerProducer(queue);
        consumerProducer.fun();
    }
}
