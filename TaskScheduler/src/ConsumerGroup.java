import java.util.ArrayList;
import java.util.List;

public class ConsumerGroup {

    int consumerGroupId = 0;

    Scheduler scheduler = null;

    SchedulerConfiguration schedulerConfiguration = null;

    List<Thread> consumer = new ArrayList<>();

    public ConsumerGroup(int consumerGroupId, Scheduler scheduler,
        SchedulerConfiguration schedulerConfiguration) {
        this.consumerGroupId = consumerGroupId;
        this.scheduler = scheduler;
        this.schedulerConfiguration = schedulerConfiguration;
        init();
    }

    public void init() {
        for (int i = 0; i < schedulerConfiguration.workerCount; i++) {
            Thread consumerThread = new Thread(new Consumer(scheduler,"consumerThread" + i));
            consumerThread.setName("consumerThread" + i);
            consumer.add(consumerThread);
        }
    }

    public void start() {
        for (int i = 0; i < consumer.size(); i++) {
            consumer.get(i).start();
        }
    }

    public void register() {
        scheduler.subscribe(consumerGroupId);
    }

    public void unregister() {
        scheduler.unsubscribe(consumerGroupId);
    }

}
