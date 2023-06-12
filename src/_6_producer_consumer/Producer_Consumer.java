package _6_producer_consumer;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;

public class Producer_Consumer {

  private volatile static boolean isStop = false;
  private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);

  public static void producer() {
    Random random = new Random();
    while(true && !isStop) {
      try {
        int value = random.nextInt(100);
        queue.put(value);
        System.out.println("Inserted value is :: "+ value);
      } catch(InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public static void consumer()  {
    Random random = new Random();
    while(true && !isStop) {
      try {
        Thread.sleep(100);
      } catch(InterruptedException e) {
        e.printStackTrace();
      }
      if(random.nextInt(10) == 0) {
        try {
          int value = queue.take();
          System.out.println("Taken value:: "+ value);
        } catch(InterruptedException e) {
          e.printStackTrace();
        }
      }

    }
  }

  public static void main(String args[]) {
    Thread t1 = new Thread(new Runnable() {
      @Override
      public void run() {
        producer();
      }
    });

    Thread t2 = new Thread(new Runnable() {
      @Override
      public void run() {
        consumer();
      }
    });

    t1.start();
    t2.start();

    Scanner sc = new Scanner(System.in);
    if(sc.hasNext()) {
      isStop = true;
    }

    System.out.println("Ended:");
  }

}
