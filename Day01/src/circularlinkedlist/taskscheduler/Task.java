package circularlinkedlist.taskscheduler;

public class Task {
    int taskID;
    String taskName;
    int priority;
    String dueDate;
    Task next;  // Points to the next task

    // Constructor to create a new task
    public Task(int taskID, String taskName, int priority, String dueDate) {
        this.taskID = taskID;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}
