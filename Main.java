/*New Cached Thread Pool*/

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
 class TestThread {
	
   public static void main(final String[] arguments) throws InterruptedException {
      ExecutorService executor = Executors.newCachedThreadPool();
      ThreadPoolExecutor pool = (ThreadPoolExecutor) executor;
      executor.submit(new Task());
      executor.submit(new Task());
      executor.shutdown();
   }  

   static class Task implements Runnable {

      public void run() {
         
         try {
            Long dur = (long) (Math.random() * 5);
            System.out.println("Running Task! Thread Name: " +
               Thread.currentThread().getName());
               TimeUnit.SECONDS.sleep(dur);
            System.out.println("Task Completed! Thread Name: " +
               Thread.currentThread().getName());
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }
   }
