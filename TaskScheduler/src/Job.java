public class Job implements Comparable<Job> {

    int jobId;

    String name;

    int timeLeft;

    public Job(int jobId) {
        this.jobId = jobId;
    }

    public Job(int jobId, int timeLeft) {
        this.jobId = jobId;
        this.timeLeft = timeLeft;
    }

    public void printMessage() {
        System.out.print("job completed for " + this.jobId);
    }

    @Override
    public int compareTo(Job job) {
        return this.getTimeLeft() - job.getTimeLeft();
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTimeLeft() {
        return timeLeft;
    }

    public void setTimeLeft(int timeLeft) {
        this.timeLeft = timeLeft;
    }
}
