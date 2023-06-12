package _7_wait_and_notify;

public class App {

  public static void main(String args[]) {
      Processor pr = new Processor();
      Thread t1 = new Thread(new Runnable() {
        @Override
        public void run() {
          try {
            pr.produce();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      });

    Thread t2 = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          pr.consume();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });

    t1.start();
    t2.start();
  }
}
