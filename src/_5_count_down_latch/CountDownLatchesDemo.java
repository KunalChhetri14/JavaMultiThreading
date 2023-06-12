package _5_count_down_latch;

import java.util.concurrent.*;

public class CountDownLatchesDemo {

  public static void main(String args[]) {

    CountDownLatch latch = new CountDownLatch(4);
    Worker worker1 = new Worker(latch, 500, "Worker 1");
    Worker worker2 = new Worker(latch, 500, "Worker 2");
    Worker worker3 = new Worker(latch, 500, "Worker 3");
    Worker worker4 = new Worker(latch, 500, "Worker 4");
    worker1.start();
    worker2.start();
    worker3.start();
    worker4.start();
    try {
      latch.await();
      System.out.println(Thread.currentThread().getName() + "   main  has finished");
    } catch(InterruptedException e) {
      e.printStackTrace();
    }
  }

}

class Worker extends Thread {

  private int delay;
  private CountDownLatch latch;

  public Worker(CountDownLatch latch, int delay, String name) {
    super(name);
    this.delay = delay;
    this.latch = latch;
  }

  @Override
  public void run() {
    try {
      Thread.sleep(delay);
      System.out.println(Thread.currentThread().getName()+ "finished");
      latch.countDown();
    } catch(InterruptedException e) {
      e.printStackTrace();
    }
  }

}
