package _8_working_example;

import java.util.*;

public class Processor2 {

  private LinkedList<Integer> list = new LinkedList<>();
  private final int LIMIT= 10;

  private Object lock1 = new Object();

  public void produce() throws InterruptedException{
    int value = 0;
    while(true) {
      synchronized (lock1) {
        list.add(value++);
        if(list.size()== LIMIT) {
          lock1.wait();
        }
      }
    }

  }

  public void consume() throws InterruptedException{
    Scanner sc = new Scanner(System.in);
    Thread.sleep(1000);
    while(true) {
      synchronized (lock1) {
        if(list.size() == 0) {
          lock1.wait();
        }
        System.out.println("List size is:: "+ list.size());
        int value = list.removeFirst();
        System.out.println("The consumed value is:: "+ value);
        lock1.notify();
      }
      Thread.sleep(1000);
    }

  }

}
