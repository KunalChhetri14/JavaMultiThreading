package _8_working_example;

public class App8 {

  public static void main(String args[]) {
      Processor2 pr = new Processor2();
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
