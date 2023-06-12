package _4_thread_pools;



//Suppose we want to use multiple thread to carry out same task then we can make use of thread pool
//Ex: Verticle consisiting of several threads

import java.util.concurrent.*;

class Process implements Runnable {

  private int id;

  public Process(int id) {
    this.id = id;
  }


  @Override
  public void run() {
    System.out.println("Starting: "+id + " ,thread is :: "+ Thread.currentThread());
    try {
      Thread.sleep(1000);
    } catch(InterruptedException ex) {
      ex.printStackTrace();
    }
    System.out.println("Completed: "+id + " , thread is :: "+Thread.currentThread());
  }
}

public class ExecutorServiceDemo {

  public static void main(String args[]) {
    ExecutorService executorService = Executors.newFixedThreadPool(4);
    for(int i=0; i<5; i++) {
      executorService.submit(new Process(i));
    }

    try {
      executorService.awaitTermination(1, TimeUnit.DAYS); //Will wait max for 1 day to complete
    } catch(InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("Process completed");
  }
}
