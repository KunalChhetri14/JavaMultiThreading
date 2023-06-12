package _0_thread_basics;
class Runner extends Thread {

  public void run() {
    for(int i=0; i<10; i++) {
      System.out.println("Hello" + i);
      try {
        Thread.sleep(200);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}

public class StartingThreads1 {

  public static void main(String args[]) {
    Runner r1 = new Runner();
    Runner r2 = new Runner();
    r1.start();
    r2.start();
    Runnable run1 = () -> {
      for(int i=0; i<15; i++) {
        System.out.println("Runnable :: "+ i);
      }
    };
    Thread t = new Thread(run1);
    t.start();
  }
}
