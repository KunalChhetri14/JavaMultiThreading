package _7_wait_and_notify;

import java.util.*;

public class Processor {

  public void produce() throws InterruptedException{
    synchronized (this) {
      System.out.println("Producer thread running");
      wait();
      System.out.println("Producer thread resumed");
    }
  }

  public void consume() throws InterruptedException{
    Scanner sc = new Scanner(System.in);
    Thread.sleep(1000);
    synchronized (this) {
      System.out.println("Waiting for return key:: ");
//      sc.nextLine();
      System.out.println("return key pressed.");
      notify();
    }
  }

}
