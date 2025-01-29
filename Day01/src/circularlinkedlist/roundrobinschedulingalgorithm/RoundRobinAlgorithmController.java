package circularlinkedlist.roundrobinschedulingalgorithm;


public class RoundRobinAlgorithmController {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler();

        // Adding processes to the scheduler
        scheduler.addProcess(1, 10, 1);
        scheduler.addProcess(2, 5, 2);
        scheduler.addProcess(3, 8, 3);
        scheduler.addProcess(4, 12, 4);

        // Display processes before scheduling
        System.out.println("Process List Before Scheduling:");
        scheduler.displayProcessList();

        // Simulate the Round Robin Scheduling with a time quantum of 4
        System.out.println("\nScheduling Processes (Time Quantum = 4):");
        scheduler.scheduleProcesses(4);

        // Display the remaining processes (if any) after scheduling
        System.out.println("\nProcess List After Scheduling:");
        scheduler.displayProcessList();
    }
}
