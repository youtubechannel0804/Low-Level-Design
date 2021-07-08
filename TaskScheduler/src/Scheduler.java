import java.util.*;

public class Scheduler {
    PriorityQueue<Job> queue = new PriorityQueue<>();

    Set<Integer> consumerGroupList = new HashSet();

    public void addJobs(Job job) {
        this.queue.add(job);
    }

    public void subscribe(int consumerGroupId) {
        consumerGroupList.add(consumerGroupId);
    }

    public void unsubscribe(int consumerGroupId) {
        consumerGroupList.remove(consumerGroupId);
    }

}
