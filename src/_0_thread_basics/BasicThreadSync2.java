package _0_thread_basics;

import java.util.*;

public class BasicThreadSync2 {

  private boolean running = true;

  public void runn() {
    int i=1;
    while(running) {
      System.out.println("Running::: "+ i);
      i++;
    }
  }

  public void shutDown() {
    running = false;
  }

  public static void main(String args[]) {
    BasicThreadSync2 bas = new BasicThreadSync2();
    Runnable run11 = () -> {
      bas.runn();
    };
    Thread t1 = new Thread(run11);
    t1.start();
    Scanner sc = new Scanner(System.in);
    sc.nextLine();
    bas.shutDown();


  }


}
