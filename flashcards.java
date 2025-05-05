import java.util.Scanner;

public class ToDoListApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tasks = new String[10]; // Fixed-size array to hold up to 10 tasks
        int taskCount = 0; // Keeps track of the number of tasks
        int choice;

        while (true) {
            System.out.println("\n===== To-Do List =====");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Delete Task");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    if (taskCount < tasks.length) {
                        System.out.print("Enter task: ");
                        String task = scanner.nextLine();
                        tasks[taskCount] = task;
                        taskCount++;
                        System.out.println("Task added!");
                    } else {
                        System.out.println("Task list is full! Cannot add more tasks.");
                    }
                    break;
                case 2:
                    System.out.println("\nYour Tasks:");
                    if (taskCount == 0) {
                        System.out.println("No tasks yet!");
                    } else {
                        for (int i = 0; i < taskCount; i++) {
                            System.out.println((i + 1) + ". " + tasks[i]);
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter task number to delete: ");
                    int taskNumber = scanner.nextInt();
                    if (taskNumber > 0 && taskNumber <= taskCount) {
                        // Shift tasks to remove the task at taskNumber-1
                        for (int i = taskNumber - 1; i < taskCount - 1; i++) {
                            tasks[i] = tasks[i + 1];
                        }
                        tasks[taskCount - 1] = null; // Remove last task reference
                        taskCount--;
                        System.out.println("Task deleted!");
                    } else {
                        System.out.println("Invalid task number!");
                    }
                    break;
                case 4:
                    System.out.println("Exiting To-Do List. Have a great day!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please enter 1-4.");
            }
        }
    }
}
