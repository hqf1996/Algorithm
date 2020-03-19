package 多线程;

/**
 * @Author: hqf
 * @description: 三个线程模拟卖票的过程
 * @Data: Create in 20:19 2020/3/17
 * @Modified By:
 */


public class ticket {
    class SellTicket implements Runnable{
        private int ticket = 50;
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (this) {
                    if (ticket > 0) {
                        ticket--;
                        System.out.println(Thread.currentThread().getName() + "卖出了1张票，剩余" + ticket);
                    } else {
                        System.out.println(Thread.currentThread().getName() + "票不足！");
                        break;
                    }
                }
            }
        }
    }

    public void fun() {
        SellTicket sellTicket = new SellTicket();
        Thread thread1 = new Thread(sellTicket, "线程1");
        Thread thread2 = new Thread(sellTicket, "线程2");
        Thread thread3 = new Thread(sellTicket, "线程3");
        thread1.start();
        thread2.start();
        thread3.start();
    }

    public static void main(String[] args) {
        ticket tt = new ticket();
        tt.fun();
    }
}

