public class App {

    public static void main(String[] args) {

        Scheduler scheduler = new Scheduler();

        Thread producerThread = new Thread(new Producer(scheduler));
        producerThread.setName("producerThread");

        SchedulerConfiguration schedulerConfiguration = new SchedulerConfiguration(
            5);
        ConsumerGroup consumerGroup = new ConsumerGroup(1, scheduler,
            schedulerConfiguration);

        producerThread.start();
        consumerGroup.start();
    }
}
