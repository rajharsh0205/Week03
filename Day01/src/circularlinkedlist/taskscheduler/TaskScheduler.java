package circularlinkedlist.taskscheduler;

public class TaskScheduler {
    private Task head;

    // Constructor to initialize the task list (empty list)
    public TaskScheduler() {
        head = null;
    }

    // Add a task at the beginning of the circular list
    public void addTaskAtBeginning(int taskID, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskID, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            newTask.next = head;  // Circular reference
        } else {
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTask;
            newTask.next = head;
            head = newTask;
        }
    }

    // Add a task at the end of the circular list
    public void addTaskAtEnd(int taskID, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskID, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            newTask.next = head;  // Circular reference
        } else {
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTask;
            newTask.next = head;
        }
    }

    // Add a task at a specific position in the circular list
    public void addTaskAtPosition(int position, int taskID, String taskName, int priority, String dueDate) {
        if (position < 1) {
            System.out.println("Position must be greater than or equal to 1.");
            return;
        }
        Task newTask = new Task(taskID, taskName, priority, dueDate);
        if (position == 1) {
            addTaskAtBeginning(taskID, taskName, priority, dueDate);
            return;
        }

        Task temp = head;
        int count = 1;

        while (temp != null && count < position - 1) {
            temp = temp.next;
            count++;
            if (temp == head) {
                break;
            }
        }

        if (temp == null || temp.next == head) {
            System.out.println("Position out of bounds.");
            return;
        }

        newTask.next = temp.next;
        temp.next = newTask;
    }

    // Remove a task by Task ID
    public void removeTaskByID(int taskID) {
        if (head == null) {
            System.out.println("The task list is empty.");
            return;
        }

        Task temp = head;
        Task prev = null;

        // If the task to be removed is the head node
        if (temp.taskID == taskID) {
            if (temp.next == head) {  // Only one task in the list
                head = null;
            } else {
                while (temp.next != head) {
                    temp = temp.next;
                }
                temp.next = head.next;
                head = head.next;
            }
            System.out.println("Task with ID " + taskID + " removed.");
            return;
        }

        // Traverse the circular list and find the task by Task ID
        prev = temp;
        temp = temp.next;
        while (temp != head) {
            if (temp.taskID == taskID) {
                prev.next = temp.next;
                System.out.println("Task with ID " + taskID + " removed.");
                return;
            }
            prev = temp;
            temp = temp.next;
        }
        System.out.println("Task with ID " + taskID + " not found.");
    }

    // View the current task and move to the next task
    public void viewCurrentTask() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        Task temp = head;
        System.out.println("Current Task: ID = " + temp.taskID + ", Name = " + temp.taskName + ", Priority = " + temp.priority + ", Due Date = " + temp.dueDate);
        head = temp.next;  // Move to the next task
    }

    // Display all tasks in the list starting from the head node
    public void displayTasks() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        Task temp = head;
        do {
            System.out.println("Task ID: " + temp.taskID + ", Name: " + temp.taskName + ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);  // Loop until we come back to the head
    }

    // Search for a task by Priority
    public void searchTaskByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        Task temp = head;
        boolean found = false;
        do {
            if (temp.priority == priority) {
                System.out.println("Task Found: ID = " + temp.taskID + ", Name = " + temp.taskName + ", Priority = " + temp.priority + ", Due Date = " + temp.dueDate);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);  // Loop until we come back to the head

        if (!found) {
            System.out.println("No task found with priority " + priority);
        }
    }
}
