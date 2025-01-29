package circularlinkedlist.taskscheduler;

public class TaskSchedulerController {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        // Adding tasks to the scheduler
        scheduler.addTaskAtBeginning(1, "Task 1", 3, "2025-03-01");
        scheduler.addTaskAtEnd(2, "Task 2", 1, "2025-02-15");
        scheduler.addTaskAtEnd(3, "Task 3", 2, "2025-03-10");
        scheduler.addTaskAtPosition(2, 4, "Task 4", 4, "2025-02-20");

        // Display all tasks
        System.out.println("All Tasks:");
        scheduler.displayTasks();

        // View current task and move to next task
        System.out.println("\nViewing current task:");
        scheduler.viewCurrentTask();

        // Search for a task by priority
        System.out.println("\nSearch Task by Priority (Priority 2):");
        scheduler.searchTaskByPriority(2);

        // Remove a task by Task ID
        scheduler.removeTaskByID(2);

        // Display all tasks after removal
        System.out.println("\nTasks after removal:");
        scheduler.displayTasks();
    }
}

