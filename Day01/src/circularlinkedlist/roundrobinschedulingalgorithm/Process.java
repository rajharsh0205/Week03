package circularlinkedlist.roundrobinschedulingalgorithm;

public class Process {
    int processID;
    int burstTime;
    int remainingBurstTime;
    int priority;
    Process next;  // Points to the next process in the circular list

    // Constructor to create a new process
    public Process(int processID, int burstTime, int priority) {
        this.processID = processID;
        this.burstTime = burstTime;
        this.remainingBurstTime = burstTime;  // Initially, remaining burst time equals the burst time
        this.priority = priority;
        this.next = null;
    }
}
