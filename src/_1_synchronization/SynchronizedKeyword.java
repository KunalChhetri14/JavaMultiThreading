package _1_synchronization;
public class SynchronizedKeyword {

  private volatile int count = 0;

  public synchronized void  increment() {
    for(int i=0; i<10000; i++) {
      count++;
    }
  }

  public static void main(String args[]) throws InterruptedException {

    SynchronizedKeyword obj = new SynchronizedKeyword();
    Thread t1 = new Thread(new Runnable() {
      @Override
      public void run() {
        obj.increment();
      }
    });

    Thread t2 = new Thread(new Runnable() {
      @Override
      public void run() {
        obj.increment();
      }
    });

    t1.start();
    t2.start();


    //Otherwise if we don't use join then it will directly go to next line of main method and hence count will be display as 0;
    try {
      t1.join();
      t2.join();
    } catch(InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("The count alue is:: "+obj.count);

  }
}
