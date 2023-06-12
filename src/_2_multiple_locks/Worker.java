package _2_multiple_locks;

import java.util.*;


//here if we don't use locks then both stageOne and stageTwo are inside synchronized block
//therefore a worker thread by default has only on intrinsic lock
//therefore if one thread runs stageOne block the another thread cannot run stageTwo as there is only on lock
//therefore we make use of locks

//suppose try using same lock1 in both stageOne and two then we use that the time taken will be more
//i.e  synchronized(lock1) for both stages
public class Worker {

  private Object lock1 = new Object();
  private Object lock2 = new Object();
  ArrayList<Integer> ar1 = new ArrayList<>();
  ArrayList<Integer> ar2 = new ArrayList<>();

  public void stageOne(int i) {
    synchronized(lock1) {
      try {
        Thread.sleep(1);
      } catch(InterruptedException ex) {
        ex.printStackTrace();
      }
      ar1.add(i);
    }

  }

  public void stageTwo(int i) {
    synchronized(lock2) {
      try {
        Thread.sleep(1);
      } catch(InterruptedException ex) {
        ex.printStackTrace();
      }
      ar2.add(i);
    }

  }

  public void process() {
    for(int i=0; i<1000; i++ ) {
      stageOne(i);
      stageTwo(i);
    }
  }

  public void main() {
//    new Worker().process();
    int k=0;
    int j = k++;
    System.out.println("K :: "+ k);
    long start = System.currentTimeMillis();
    Thread t1 = new Thread(new Runnable() {
      @Override
      public void run() {
        process();
      }
    });

    Thread t2 = new Thread(new Runnable() {
      @Override
      public void run() {
        process();
      }
    });

    t1.start();
    t2.start();

    try {
      t1.join();
      t2.join();
    } catch(InterruptedException ex) {
      ex.printStackTrace();
    }
    long end = System.currentTimeMillis();
    System.out.println("Time taken: " + (end - start));
    System.out.println("List1: " + ar1.size() + "; List2: " + ar2.size());
  }

}
