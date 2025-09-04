package task_management;

import java.util.Scanner;

public class TaskManagementApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskService service = new TaskService();

        while (true) {
            System.out.println("\n--- Task Management System ---");
            System.out.println("1. Add Task");
            System.out.println("2. View All Tasks");
            System.out.println("3. Update Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Mark Task as Completed");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    service.addTask(sc);
                    break;
                case 2:
                    service.viewTasks();
                    break;
                case 3:
                    service.updateTask(sc);
                    break;
                case 4:
                    service.deleteTask(sc);
                    break;
                case 5:
                    service.markTaskCompleted(sc);
                    break;
                case 6:
                    System.out.println("Exiting... Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
