import java.util.Random;

class Consumer implements Runnable {
    Scheduler scheduler = null;

    String name;

    public Consumer(Scheduler scheduler, String name) {
        this.scheduler = scheduler;
        this.name = name;
    }

    @Override
    public void run() {

        while (true) {
            synchronized (scheduler.queue) {
               // try {

                    while (scheduler.queue.size() == 0) {
                        System.out
                            .println("Thread: " + this.name + " is waiting");
                        try {
                            scheduler.queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    Job job = scheduler.queue.poll();

                    System.out
                        .println("job poll " + job.jobId + " by" + this.name);
                    Random random = new Random();
                   // Thread.sleep(random.nextInt(2000));

//                } catch (InterruptedException e) {
//                    System.out.println(
//                        Thread.currentThread().getName() + " interrupted.");
//                }
                // scheduler.queue.notifyAll();
            }
        }
    }
}