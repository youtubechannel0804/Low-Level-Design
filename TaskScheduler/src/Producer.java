import java.util.List;
import java.util.Random;

class Producer implements Runnable {
    int index = 0;

    Scheduler scheduler = null;

    public Producer(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    @Override
    public void run() {

        while (true) {
            synchronized (scheduler.queue) {
               // try {
                    scheduler.addJobs(new Job(index));
                    index++;
                    Random random = new Random();
                   // Thread.sleep(random.nextInt(2000));
                    System.out
                        .println(Thread.currentThread().getName() + " added " + index);
//                } catch (InterruptedException e) {
//                    System.out.println(
//                        Thread.currentThread().getName() + " interrupted.");
//                }
                scheduler.queue.notifyAll();
            }


        }
    }

}